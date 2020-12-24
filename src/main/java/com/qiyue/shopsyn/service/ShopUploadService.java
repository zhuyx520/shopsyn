package com.qiyue.shopsyn.service;

import com.qiyue.shopsyn.vo.request.ShopVo;
import com.qiyue.shopsyn.vo.response.Response;

public interface ShopUploadService {

    String uploadImage();					// 上传图片

    Response uploadGrabShop(ShopVo shopVo);				// 上传抓取的数据到商铺交易中心--通过商铺平台提供的商铺发布接口

    Response uploadGrabShopMysql(ShopVo shopVo);			// 上传抓取的数据到胜浦交易中心--直接修改表数据

}
