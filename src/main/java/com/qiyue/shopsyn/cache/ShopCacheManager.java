package com.qiyue.shopsyn.cache;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.qiyue.shopsyn.entity.ShopBean;
import com.qiyue.shopsyn.entity.ShopBusinessBean;
import com.qiyue.shopsyn.helper.ShopHelper;
import com.qiyue.shopsyn.remote.ShopDataRemote;
import com.qiyue.shopsyn.util.ChinaCharUtil;
import com.qiyue.shopsyn.util.GsonUtil;
import com.qiyue.shopsyn.util.MultipartFileUtil;
import com.qiyue.shopsyn.util.PictureOperationUtil;
import com.qiyue.shopsyn.util.ShopConstant;
import com.qiyue.shopsyn.vo.response.Response;

@Service
public class ShopCacheManager {
	
	private static final Logger log = LogManager.getLogger(ShopCacheManager.class);

    @Autowired(required = false)
    private ShopDataRemote shopDataRemote;
    @Autowired
    private ShopHelper shopHelper;
    
    public String uploadImage(String imagePath) {
    	// 两种方式都可以
    	MultipartFile file = PictureOperationUtil.getMulFileByPath(imagePath,"files");
    	
//    	File newfile = new File(imagePath);
//    	MultipartFile file = MultipartFileUtil.from(newfile,"files");
    	
    	MultipartFile[] files = new MultipartFile[]{file};
    	
    	JSONObject info = shopDataRemote.uploadImage(files);
    	String code = info.containsKey("code")?info.getString("code"):"";
		if( "0".equals(code)) {
			String imageUrl = info.containsKey("filesUpload")?info.getString("filesUpload"):"";
			return imageUrl.replace("[", "").replace("]", "");
		}
		return "";
    }
    
    public Response uploadData(ShopBean shopBean, String resUrl) {
    	log.info("SHOP_BEAN: "+GsonUtil.toJson(shopBean));
    	Map<String,Object> param = shopHelper.getShopMap(shopBean, resUrl);
    	log.info("SHOP_MAP: "+GsonUtil.toJson(param));
    	JSONObject info = shopDataRemote.uploadData(param);
    	String code = info.containsKey("code")?info.getString("code"):"";
		if("0".equals(code)) {
			return Response.ok();
		}else {
			String code1 = info.containsKey("code")?info.getString("code"):"";
			String msg = info.containsKey("msg")?info.getString("msg"):"";
			return Response.error(Integer.valueOf(code1), msg);
		}
		
    }
    
    
    public Response uploadBusinessData(ShopBusinessBean shopBusinessBean, String resUrl) {
    	log.info("SHOP_BUSINESS_BEAN: "+GsonUtil.toJson(shopBusinessBean));
    	Map<String,Object> param = shopHelper.getShopBusinessMap(shopBusinessBean, resUrl);
    	log.info("SHOP_BUSINESS_MAP: "+GsonUtil.toJson(param));
    	JSONObject info = shopDataRemote.uploadData(param);
    	String code = info.containsKey("code")?info.getString("code"):"";
		if("0".equals(code)) {
			return Response.ok();
		}else {
			String code1 = info.containsKey("code")?info.getString("code"):"";
			String msg = info.containsKey("msg")?info.getString("msg"):"";
			return Response.error(Integer.valueOf(code1), msg);
		}
		
    }
    
}
