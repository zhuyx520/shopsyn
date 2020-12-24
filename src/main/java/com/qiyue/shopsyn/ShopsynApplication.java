package com.qiyue.shopsyn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.qiyue.shopsyn" })
@EnableFeignClients
public class ShopsynApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopsynApplication.class, args);
	}

}
