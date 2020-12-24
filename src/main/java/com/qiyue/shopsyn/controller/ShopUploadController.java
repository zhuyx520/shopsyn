package com.qiyue.shopsyn.controller;

import javax.annotation.Resource;

import com.qiyue.shopsyn.service.ShopUploadService;
import com.qiyue.shopsyn.util.DateTimeUtil;
import com.qiyue.shopsyn.vo.request.ShopVo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qiyue.shopsyn.vo.response.Response;

import java.util.Date;

@RestController
@RequestMapping(value = "shop/uploadShop")
public class ShopUploadController {

	private static final Logger log = LogManager.getLogger(ShopUploadController.class);

    @Resource
    private ShopUploadService shopUploadService;

    @RequestMapping(value = "image", method = {RequestMethod.GET})            // 测试使用
    public Response data1() {
        String str = shopUploadService.uploadImage();
        log.info("上传后的路径：" + str);
        return Response.exception(0, "OK", str);
    }

    @RequestMapping(value = "data", method = {RequestMethod.GET})            // 手动同步使用
    public Response data(String startTime, String endTime) {
        ShopVo shopVo = new ShopVo();
        shopVo.setGrabtimeS(startTime);
        shopVo.setGrabtimeE(endTime);
        Response response = shopUploadService.uploadGrabShopMysql(shopVo);
        return response;
    }


}
