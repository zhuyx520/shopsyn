package com.qiyue.shopsyn.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;

// 商铺发布
@Data
public class ShopBean {

	private String id;					// id
	private String title;				// 标题
	private String href;				// 网页链接
	private String city;				// 城市
	private String name;				// 联系人
	private String phone;				// 电话
	private String monthRent;			// 月租
	private String mortgagePayment;		// 押付
	private String area;				// 建筑面积
	private String shopType;			// 商铺类型
	private String shopNature;			// 商铺性质
	private String managementState;		// 经营状态
	private String managementType;		// 经营类型
	private String floor;				// 楼层
	private String normsWide;			// 宽
	private String normsHigh;			// 层高
	private String normsDeep;			// 深
	private String description;			// 描述
	private String matched;				// 配套
	private String img;					// 图片链接
	private String region;				// 区域
	private String address;				// 地址
	private String crowd;				// 客流人群
	private String relatedCosts;		// 相关费用
	@JSONField(format="yyyy-MM-dd hh:mm:ss")
	private Date grabtime;				// 抓取时间

}
