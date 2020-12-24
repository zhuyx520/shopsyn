package com.qiyue.shopsyn.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.qiyue.shopsyn.service.ShopService;
import com.qiyue.shopsyn.service.ShopUploadService;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qiyue.shopsyn.cache.ShopCacheManager;
import com.qiyue.shopsyn.dao.second.QyReleaseShopsMapper;
import com.qiyue.shopsyn.entity.QyReleaseShopsEntity;
import com.qiyue.shopsyn.entity.ShopBean;
import com.qiyue.shopsyn.entity.ShopBusinessBean;
import com.qiyue.shopsyn.helper.PythonHelper;
import com.qiyue.shopsyn.helper.ShopHelper;
import com.qiyue.shopsyn.util.ChinaCharUtil;
import com.qiyue.shopsyn.util.DateTimeUtil;
import com.qiyue.shopsyn.util.FileWUtil;
import com.qiyue.shopsyn.util.GsonUtil;
import com.qiyue.shopsyn.util.PictureOperationUtil;
import com.qiyue.shopsyn.util.ShopConstant;
import com.qiyue.shopsyn.vo.request.ShopVo;
import com.qiyue.shopsyn.vo.response.Response;

@Service
public class ShopUploadServiceImpl implements ShopUploadService {

	private static final Logger log = LogManager.getLogger(ShopUploadServiceImpl.class);

	@Value("${shop.path.image}")
    private String imagePath;

	@Value("${shop.path.python.file}")
	private String pythonFile;

	@Value("${shop.path.mask.file}")
	private String maskFile;

	@Resource
	private ShopService shopService;
	@Resource
	private ShopCacheManager shopCacheManager;
	@Resource
	private ShopHelper shopHelper;
	@Resource
	private QyReleaseShopsMapper qyReleaseShopsMapper;

	// 仅供测试使用
	@Override
	public String uploadImage() {
		// 1 获取图片链接
		String url = "https://pic7.58cdn.com.cn/p1/tiny/n_v2989acb7dbc1b4921a1b261e71489ec8b.jpg?w=480&h=360&corp=1";
		// 2 下载图片
        String localPath=imagePath + shopHelper.getUrlPath(url);
        String dirPath = localPath.substring(0, localPath.lastIndexOf("/"));
        if(!FileWUtil.isFolder(dirPath)) {
        	FileWUtil.createFolder(dirPath);
        }
        boolean flag = PictureOperationUtil.downloadPicture(url,localPath);
        // 3 上传图片
        if(flag) {
        	return shopCacheManager.uploadImage(localPath);
        }
        return "";
	}

	@Override
	public Response uploadGrabShop(ShopVo shopVo) {
		List<ShopBean> list = shopService.getPageConditionMessageGroupByPhone(shopVo,1,9999);
		log.info("本次需要上传的商铺发布数据条数：" + list.size() );
		int cnt = 0;				// 记录已发布的手机号条数
		int success = 0;			// 记录成功上传的数据条数
		for(ShopBean shopBean : list) {
			if(StringUtils.isBlank(shopBean.getPhone())) {
				continue;
			}
			if(shopBean.getPhone().lastIndexOf("-") != -1){
				continue;
			}

			String pictureUrl = shopBean.getImg();
			List<String> localImgListPath = shopHelper.downloadImageList(pictureUrl);		// 批量下载
			List<String> outputList = shopHelper.outputList(localImgListPath);
			boolean flag = PythonHelper.removeWatermaskList(pythonFile, localImgListPath, outputList, maskFile);	// 批量去除水印
			if(!flag) {
				log.error(DateTimeUtil.getCurrentDate() + "---图片水印未去除---"+GsonUtil.toJson(outputList));
				return Response.exception(0, "水印未去除！", localImgListPath);
			}
			String uploadImgPath = shopHelper.uploadImageList(outputList);			// 批量上传

			if(uploadImgPath != null && !"".equals(uploadImgPath)) {
				Response response = shopCacheManager.uploadData(shopBean,uploadImgPath);
				if(response.getCode() != 0) {
					if(response.getCode() == 120) {
						cnt += 1;
						continue;
					}
					log.error(DateTimeUtil.getCurrentDate() + "---数据上传错误---"+GsonUtil.toJson(response));
					return Response.exception(response.getCode(), response.getMsg(), shopBean);
				}else {
					success += 1;
				}
			}
		}
		return Response.exception(0, "数据上传成功", "数据成功上传条数： "+success + "已发布手机号条数： " + cnt);
	}

	@Override
	public Response uploadGrabShopMysql(ShopVo shopVo) {
		List<ShopBean> list = shopService.getPageConditionMessageGroupByPhone(shopVo,1,9999);
		log.info("本次需要上传的商铺发布数据条数：" + list.size() );
		int cnt = 0;				// 记录已发布的手机号条数
		int success = 0;			// 记录成功上传的数据条数
		int fail = 0;				// 记录错误上传的数据条数
		int failPhone = 0;			// 记录手机号为空的数据条数
		List<ShopBean> failList = new ArrayList<ShopBean>();		// 记录错误发布的数据
		for(ShopBean shopBean : list) {
			if(StringUtils.isBlank(shopBean.getPhone())) {
				failPhone = failPhone + 1;
				continue;
			}
			if(shopBean.getPhone().lastIndexOf("-") != -1){
				continue;
			}
			String pictureUrl = shopBean.getImg();

			List<String> localImgListPath = shopHelper.downloadImageList(pictureUrl);		// 批量下载
			List<String> outputList = shopHelper.outputList(localImgListPath);
			boolean flag = PythonHelper.removeWatermaskList(pythonFile, localImgListPath, outputList, maskFile);	// 批量去除水印
			if(!flag) {
				log.error(DateTimeUtil.getCurrentDate() + "---图片水印未去除---"+GsonUtil.toJson(outputList));
				return Response.exception(0, "水印未去除！", localImgListPath);
			}
			String uploadImgPath = shopHelper.uploadImageList(outputList);			// 批量上传

			if(uploadImgPath != null && !"".equals(uploadImgPath)) {
				QyReleaseShopsEntity entity = qyReleaseShopsMapper.queryObject(shopBean.getPhone());
				String oldPic = "";
				if(entity != null) {			// 商铺平台已有 此商户的发布信息，直接更新表数据
					if(StringUtils.isNotBlank(entity.getShPic())){
						oldPic = entity.getShPic();
					}
					log.info("商铺平台已有 此商户的发布信息，直接更新表数据：" + GsonUtil.toJson(entity) );
					cnt += 1;
					entity.setRePhone(shopBean.getPhone());
					entity.setReName(shopBean.getName());
					entity.setReType(2);
					entity.setArer(shopBean.getRegion().split(" ")[0] + "区");
					entity.setShAddress(shopBean.getAddress());
					entity.setReTime(DateTimeUtil.formatTime(new Date(), DateTimeUtil.yyyyMMddHHmmss));
					entity.setUpdateTime(DateTimeUtil.formatTime(new Date(), DateTimeUtil.yyyyMMddHHmmss));
					if(shopBean.getTitle() != null && shopBean.getTitle() != "") {
						entity.setShName(ChinaCharUtil.getChinaChar(shopBean.getTitle()));						// 是否过滤数据
					}
					if(shopBean.getMonthRent() != null && shopBean.getMonthRent() != "") {
						entity.setRentPrice(ChinaCharUtil.getPrice(shopBean.getMonthRent().split("/")[0]));
					}
					if(shopBean.getArea() != null && shopBean.getArea() != "") {
						String area = shopBean.getArea().split("m")[0];
						if(area.lastIndexOf(".") != -1){
							area = area.substring(0, area.lastIndexOf("."));
						}
						entity.setShAcreage(Integer.valueOf(area));
					}
					entity.setShType(ShopConstant.getShType(shopBean.getManagementType()));			// 经营类型 21 种
					entity.setShParts(ShopConstant.getShPartTypeS(shopBean.getMatched()));										// 配套类型
					entity.setShPic(uploadImgPath);
					entity.setShDescribe(ChinaCharUtil.getDescription(shopBean.getDescription()));
					Integer tmpCnt = qyReleaseShopsMapper.update(entity);
					log.info("表数据修改--修改前：SHOP_BEAN: "+GsonUtil.toJson(shopBean));
					log.info("表数据修改--修改后：QY_SHOP_ENTITY: " + GsonUtil.toJson(entity));
					if(tmpCnt <= 0) {
						return Response.exception(500, "修改表数据失败！", shopBean);
					}else {
						success = success + 1;
					}
					shopHelper.deleteOldPic(oldPic);
				}else {
					Response response = shopCacheManager.uploadData(shopBean,uploadImgPath);
					if(response.getCode() != 0) {
						if(response.getCode() == 120) {
							cnt += 1;
							continue;
						}
						fail = fail +1;
						failList.add(shopBean);
					}else {
						success += 1;
					}
				}
			}
		}
		log.error(DateTimeUtil.getCurrentDate() + "---错误上传的数据---"+GsonUtil.toJson(failList));
		return Response.exception(0, "数据上传完成", "数据成功发布条数： "+success + "发布异常条数： " + fail + "手机号为空的数据条数： " + failPhone + "已发布手机号条数： " + cnt);
	}

}
