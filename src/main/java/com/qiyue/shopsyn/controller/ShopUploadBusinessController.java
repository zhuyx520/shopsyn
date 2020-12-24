package com.qiyue.shopsyn.controller;

import javax.annotation.Resource;

import com.qiyue.shopsyn.service.ShopUploadBusinessService;
import com.qiyue.shopsyn.util.DateTimeUtil;
import com.qiyue.shopsyn.vo.request.ShopBusinessVo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qiyue.shopsyn.vo.response.Response;

import java.util.Date;

@RestController
@RequestMapping(value = "shop/uploadBusiness")
public class ShopUploadBusinessController {

	private static final Logger log = LogManager.getLogger(ShopUploadBusinessController.class);

    @Resource
    private ShopUploadBusinessService shopUploadBusinessService;

    @RequestMapping(value = "image", method = {RequestMethod.GET})            // 手动同步使用
    public Response image() {
        String str = shopUploadBusinessService.uploadImage();
        log.info("上传后的路径：" + str);
        return Response.exception(0, "OK", str);
    }

    @RequestMapping(value = "data", method = {RequestMethod.GET})            // 手动同步使用
    public Response data(String startTime, String endTime) {
        ShopBusinessVo shopBusinessVo = new ShopBusinessVo();
        shopBusinessVo.setGrabtimeS(startTime);
        shopBusinessVo.setGrabtimeE(endTime);
        Response response = shopUploadBusinessService.uploadGrabShopMysql(shopBusinessVo);
        return response;
    }

}
