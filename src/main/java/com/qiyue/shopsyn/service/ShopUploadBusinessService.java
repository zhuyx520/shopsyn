package com.qiyue.shopsyn.service;

import com.qiyue.shopsyn.vo.request.ShopBusinessVo;
import com.qiyue.shopsyn.vo.response.Response;

public interface ShopUploadBusinessService {
	
    String uploadImage();					// 上传图片
    
    Response uploadGrabShop(ShopBusinessVo shopBusinessVo);				// 上传抓取的数据到商铺交易中心--通过商铺平台提供的商铺发布接口
    
    Response uploadGrabShopMysql(ShopBusinessVo shopBusinessVo);			// 上传抓取的数据到商铺交易--直接修改表数据

}
