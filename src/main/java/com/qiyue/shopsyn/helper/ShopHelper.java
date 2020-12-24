package com.qiyue.shopsyn.helper;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.qiyue.shopsyn.util.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.qiyue.shopsyn.cache.ShopCacheManager;
import com.qiyue.shopsyn.entity.ShopBean;
import com.qiyue.shopsyn.entity.ShopBusinessBean;

@Component
public class ShopHelper {
	
	@Value("${shop.path.image}")
    private String imagePath;
	
	@Value("${shop.path.python.file}")
	private String pythonFile;
	
	@Value("${shop.path.output.file}")
	private String outputFile;
	
	@Value("${shop.path.mask.file}")
	private String maskFile;
	
	@Resource
	private ShopCacheManager shopCacheManager;
	
	/*
	 * 根据58图片地址获取本地存储路径
	 */
	public String getUrlPath(String urlstr) {
        URL url = null;
        try {
			url = new URL(urlstr);
		} catch (IOException e) {
			e.printStackTrace();
		}
        return url.getPath();
	}
	
	public List<String> downloadImageList(String imageWebPath) {
		List<String> resultList = new ArrayList<String>();
		String[] imageListPath = imageWebPath.split(",");
		for (String oneImage : imageListPath) {
			String oneLocalPath = imagePath + getUrlPath(oneImage);
			String dirPath = oneLocalPath.substring(0, oneLocalPath.lastIndexOf("/"));		// 文件夹不存在就创建
	        if(!FileWUtil.isFolder(dirPath)) {
	        	FileWUtil.createFolder(dirPath);
	        }
	        if(oneLocalPath.indexOf(".") == -1) {
	        	oneLocalPath = oneLocalPath + ".jpg";
	        }
	        if(!FileWUtil.isFile(oneLocalPath)) {
	        	boolean flag = PictureOperationUtil.downloadPicture(oneImage,oneLocalPath);
				if(flag) {
					resultList.add(oneLocalPath);
				}else {
					return resultList;
				}
	        }else {
	        	resultList.add(oneLocalPath);
	        }
		}

		// 过滤非.png/.jpg/.jpeg格式的图片
		List<String> stringList = new ArrayList<>(resultList.size());
		for(String img : resultList){
			String picSuffix = img.substring(img.lastIndexOf(".") + 1);
			if("png".equals(picSuffix) || "jpg".equals(picSuffix) || "jpeg".equals(picSuffix)){
				stringList.add(img);
			}
		}
		return stringList;
	}
	
	public String uploadImageList(List<String> list) {
		StringBuffer sp = new StringBuffer();
		for(String onePath : list) {
			boolean flag = FileWUtil.isFile(onePath);
			if(!flag) {
				ShopConstant.sleep(1000 * 3L);											// 休眠3s
				flag = FileWUtil.isFile(onePath);
				if(!flag) {
					String inputPath = getInputFileByOutputFile(onePath);
					PythonHelper.removeWatermask(pythonFile, inputPath, onePath, maskFile);	// 单个去除水印
					ShopConstant.sleep(1000L);											// 休眠3s
				}
			}
			String str = shopCacheManager.uploadImage(onePath);
			sp.append(str + ",");
		}
		if(sp.length() > 10) {
			sp.deleteCharAt(sp.length()-1);
		}
		return sp.toString();
	}
	
	// 去除水印后的目录
	public List<String> outputList(List<String> list) {
		List<String> result = new ArrayList<String>();
		for(String str : list) {
			String tmp = str.split("input")[1];
			String oneLocalPath = outputFile + tmp;
			String dirPath = oneLocalPath.substring(0, oneLocalPath.lastIndexOf("/"));		// 文件夹不存在就创建
	        if(!FileWUtil.isFolder(dirPath)) {
	        	FileWUtil.createFolder(dirPath);
	        }
	        if(oneLocalPath.indexOf(".") == -1) {
	        	oneLocalPath = oneLocalPath + ".jpg";
	        }
	        result.add(oneLocalPath);
		}
		return result;
	}
	
	public String getInputFileByOutputFile(String outputFile) {
		String tmp = outputFile.split("output")[1];
		String inputPath = imagePath + tmp;
		return inputPath;
	}

	public boolean deleteOldPic(String oldPic) {
		if(StringUtils.isBlank(oldPic)){
			return true;
		}
		String[] picList = oldPic.split(",");
		for (String pic : picList){
			if(StringUtils.contains(pic, "new.cbe.com.cn")){
				// 删除E:\server\img
				String removePath = StringUtils.replace(pic, "http://new.cbe.com.cn", "E:/server");
				boolean flag = FileWUtil.delFile(removePath);
				if(!flag){
					return false;
				}
			}
		}
		return true;
	}

	// 1-商铺性质 2-客流人群 3-相关费用
	public Map<String,Object> getShopMap(ShopBean shopBean, String resUrl){
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("reId", "78");
    	param.put("rePhone", shopBean.getPhone());
    	param.put("reName", shopBean.getName());
    	param.put("reType", "2");
		if(shopBean.getCity() != null && shopBean.getCity() != "") {
			param.put("province", shopBean.getCity().split("-")[0]);
			param.put("city", shopBean.getCity().split("-")[1]);
		}
    	param.put("arer", shopBean.getRegion().split(" ")[0]);
    	param.put("shAddress", shopBean.getAddress());
    	if(shopBean.getTitle() != null && shopBean.getTitle() != "") {
    		param.put("shName", ChinaCharUtil.getChinaChar(shopBean.getTitle()));						// 是否过滤数据
    	}
    	if(shopBean.getMonthRent() != null && shopBean.getMonthRent() != "") {
    		param.put("rentPrice", ChinaCharUtil.getPrice(shopBean.getMonthRent().split("/")[0]));
    	}
    	param.put("attornPrice", "0");
    	if(shopBean.getArea() != null && shopBean.getArea() != "") {
    		param.put("shAcreage", shopBean.getArea().split("m")[0]);
    	}

    	// 类型为int类型，没法转换
//		if(shopBean.getNormsWide() != null && shopBean.getNormsWide() != "") {
//			param.put("shAcreageW", shopBean.getNormsWide());
//		}
//		if(shopBean.getNormsHigh() != null && shopBean.getNormsHigh() != "") {
//			param.put("shAcreageH", shopBean.getNormsHigh());
//		}
//		if(shopBean.getFloor() != null && shopBean.getFloor() != "") {
//			param.put("shLayerNum", shopBean.getFloor());
//		}

    	param.put("shRegionType", "80");									// 商铺区域类型
    	param.put("shType", ShopConstant.getShType(shopBean.getManagementType()));			// 经营类型 21 种
    	param.put("shParts", ShopConstant.getShPartTypeS(shopBean.getMatched()));										// 配套类型
    	param.put("shPic", resUrl);
    	param.put("shDescribe", ChinaCharUtil.getDescription(shopBean.getDescription()));
    	return param;
	}

	// 1-商铺性质 2-客流人群 3-相关费用
	public Map<String,Object> getShopBusinessMap(ShopBusinessBean shopBusinessBean, String resUrl){
		Map<String,Object> param = new HashMap<String,Object>();
    	param.put("reId", "78");
    	param.put("rePhone", shopBusinessBean.getPhone());
    	param.put("reName", shopBusinessBean.getName());
    	param.put("reType", "1");
		if(shopBusinessBean.getCity() != null && shopBusinessBean.getCity() != "") {
			param.put("province", shopBusinessBean.getCity().split("-")[0]);
			param.put("city", shopBusinessBean.getCity().split("-")[1]);
		}
    	if(shopBusinessBean.getAddress() != null && shopBusinessBean.getAddress() != "") {
			String tmpArea = shopBusinessBean.getRegion().split("-")[0];
    		if("浦东".equals(tmpArea)){
				tmpArea = "浦东新区";
			}
    		param.put("arer", tmpArea);
    	}
    	if(shopBusinessBean.getAddress() != null && shopBusinessBean.getAddress() != "") {
    		param.put("shAddress", shopBusinessBean.getAddress());
    	}
    	if(shopBusinessBean.getTitle() != null && shopBusinessBean.getTitle() != "") {
    		param.put("shName", ChinaCharUtil.getChinaChar(shopBusinessBean.getTitle()));						// 是否过滤数据
    	}
    	if(shopBusinessBean.getMonthRent() != null && shopBusinessBean.getMonthRent() != "") {
    		param.put("rentPrice", ChinaCharUtil.getPrice(shopBusinessBean.getMonthRent().split("/")[0]));
    	}
    	if(shopBusinessBean.getTransferPrice() != null && shopBusinessBean.getTransferPrice() != "") {
    		param.put("attornPrice", ChinaCharUtil.getPrice(shopBusinessBean.getTransferPrice()));
    	}
    	if(shopBusinessBean.getArea() != null && shopBusinessBean.getArea() != "") {
    		param.put("shAcreage", shopBusinessBean.getArea().split("m")[0]);
    	}

//		if(shopBusinessBean.getNormsWide() != null && shopBusinessBean.getNormsWide() != "") {
//			param.put("shAcreageW", shopBusinessBean.getNormsWide());
//		}
//		if(shopBusinessBean.getNormsHigh() != null && shopBusinessBean.getNormsHigh() != "") {
//			param.put("shAcreageH", shopBusinessBean.getNormsHigh());
//		}
//		if(shopBusinessBean.getFloor() != null && shopBusinessBean.getFloor() != "") {
//			param.put("shLayerNum", shopBusinessBean.getFloor());
//		}

    	param.put("shRegionType", "80");									// 商铺区域类型
    	param.put("shType", ShopConstant.getShType(shopBusinessBean.getManagementType()));			// 经营类型 21 种
    	param.put("shParts", ShopConstant.getShPartTypeS(shopBusinessBean.getMatched()));										// 配套类型
    	param.put("shPic", resUrl);
    	param.put("shDescribe", ChinaCharUtil.getDescription(shopBusinessBean.getDescription()));
    	return param;
	}
}
