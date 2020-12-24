package com.qiyue.shopsyn.vo.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.qiyue.shopsyn.util.ExcelExportUtils;
import lombok.Data;

import java.util.Date;

// 生意转让
@Data
public class ShopBusinessResponse {

	private String id;					// id

	@ExcelExportUtils.ExcelCell(value = "标题", index = 1)
	private String title;				// 标题

	private String href;				// 网页链接

	@ExcelExportUtils.ExcelCell(value = "城市", index = 2)
	private String city;				// 城市

	@ExcelExportUtils.ExcelCell(value = "联系人", index = 3)
	private String name;				// 联系人

	@ExcelExportUtils.ExcelCell(value = "电话", index = 4)
	private String phone;				// 电话

	@ExcelExportUtils.ExcelCell(value = "月租", index = 5)
	private String monthRent;			// 月租

	@ExcelExportUtils.ExcelCell(value = "转让价格", index = 6)
	private String transferPrice;		// 转让价格

	@ExcelExportUtils.ExcelCell(value = "押付", index = 7)
	private String mortgagePayment;		// 押付

	@ExcelExportUtils.ExcelCell(value = "剩余租期", index = 8)
	private String remainingTenancy;	// 剩余租期

	@ExcelExportUtils.ExcelCell(value = "建筑面积", index = 9)
	private String area;				// 建筑面积

	@ExcelExportUtils.ExcelCell(value = "商铺类型", index = 10)
	private String shopType;			// 商铺类型

	@ExcelExportUtils.ExcelCell(value = "商铺性质", index = 11)
	private String shopNature;			// 商铺性质

	@ExcelExportUtils.ExcelCell(value = "经营状态", index = 12)
	private String managementState;		// 经营状态

	@ExcelExportUtils.ExcelCell(value = "经营类型", index = 13)
	private String managementType;		// 经营类型

	@ExcelExportUtils.ExcelCell(value = "楼层", index = 14)
	private String floor;				// 楼层

	@ExcelExportUtils.ExcelCell(value = "规格-宽", index = 15)
	private String normsWide;			// 规格-宽

	@ExcelExportUtils.ExcelCell(value = "规格-高", index = 16)
	private String normsHigh;			// 规格-高

	@ExcelExportUtils.ExcelCell(value = "规格-深", index = 17)
	private String normsDeep;			// 规格-深

	@ExcelExportUtils.ExcelCell(value = "描述", index = 18)
	private String description;			// 描述

	@ExcelExportUtils.ExcelCell(value = "配套", index = 19)
	private String matched;				// 配套

	@ExcelExportUtils.ExcelCell(value = "图片链接", index = 20)
	private String img;					// 图片链接

	@ExcelExportUtils.ExcelCell(value = "区域", index = 21)
	private String region;				// 区域

	@ExcelExportUtils.ExcelCell(value = "地址", index = 22)
	private String address;				// 地址

	@ExcelExportUtils.ExcelCell(value = "客流人群", index = 23)
	private String crowd;				// 客流人群

	@ExcelExportUtils.ExcelCell(value = "相关费用", index = 24)
	private String relatedCosts;		// 相关费用

	@ExcelExportUtils.ExcelCell(value = "抓取时间", index = 25)
	@JSONField(format="yyyy-MM-dd hh:mm:ss")
	private Date grabtime;				// 抓取时间

}
