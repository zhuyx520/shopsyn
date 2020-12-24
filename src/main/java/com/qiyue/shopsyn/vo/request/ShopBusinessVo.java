package com.qiyue.shopsyn.vo.request;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;


@Data
public class ShopBusinessVo {

	public String city;						// 省市

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public String grabtimeS;				// 抓取时间开始
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public String grabtimeE;				// 抓取时间结束
	
	private Integer page;
	private Integer limit;
}
