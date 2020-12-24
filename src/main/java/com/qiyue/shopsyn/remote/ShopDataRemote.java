package com.qiyue.shopsyn.remote;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.qiyue.shopsyn.config.FeignConfiguration;

@FeignClient(name = "${remote.shop.name}", url = "${remote.shop.url}", fallbackFactory = com.qiyue.shopsyn.remote.ShopDataRemoteFeedback.class, configuration = FeignConfiguration.class)
public interface ShopDataRemote {

    /**
     * 图片上传
     * @param files 图片
     * @return
     */
    @RequestMapping(value = "${remote.shop.upload-image}", method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public JSONObject uploadImage(@RequestPart(value = "files", required = false) MultipartFile[] files);

//    /**
//     * 商铺转让数据上传
//     *
//     * @param request 商铺转让数据
//     * @return
//     */
//    @RequestMapping(value = "${remote.shop.upload-data}", method = RequestMethod.POST)
//    public JSONObject uploadData(@RequestParam(required = false) Map<String, Object> request);

    /**
     * 商铺转让数据上传
     *
     * @param request 商铺转让数据
     * @return
     */
    @RequestMapping(value = "${remote.shop.upload-data}", method = RequestMethod.POST)
    public JSONObject uploadData(@RequestBody(required = false) Map<String, Object> request);

}
