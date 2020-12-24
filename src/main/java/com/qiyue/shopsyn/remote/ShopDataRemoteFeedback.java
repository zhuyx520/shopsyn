package com.qiyue.shopsyn.remote;

import feign.hystrix.FallbackFactory;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

@Component
public class ShopDataRemoteFeedback implements FallbackFactory<ShopDataRemote> {
	
	private JSONObject getErrorResponse() {
		JSONObject response = new JSONObject();
		response.put("code", "500");
        response.put("msg", "数据上传服务调用熔断");
        return response;
    }

	
    @Override
    public ShopDataRemote create(Throwable cause) {
        return new ShopDataRemote() {

			@Override
			public JSONObject uploadImage(MultipartFile[] file) {
				return getErrorResponse();
			}

			@Override
			public JSONObject uploadData(Map<String,Object> request) {
				return getErrorResponse();
			}
        };
    }
}
