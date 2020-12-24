package com.qiyue.shopsyn.config;

import feign.Logger;
import feign.codec.Encoder;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.feign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class FeignConfiguration{
	
	@Autowired
    public ObjectFactory<HttpMessageConverters> messageConverters;
	
    @Bean
    Logger.Level feignLoggerLevel() {
    	/*
    	 * 记录日志级别；NONE-无记录；
    	 * BASIC-记录方法，URL响应代码和执行时间；
    	 * HEADERS-记录基本信息，请求和标头，
    	 * FULL请求，头文件，正文和元数据
    	 */
        return Logger.Level.FULL;
    }
    
    // 上传文件的配置
    @Bean
    @Primary
    @Scope("prototype")
    public Encoder multipartFormEncoder() {
    	return new SpringMultipartEncoder(new SpringEncoder(messageConverters));
    }

}