package com.qiyue.shopsyn.entity;

import java.io.Serializable;

import lombok.Data;


/**
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-10-28 13:03:43
 */
@Data
public class QyReleaseShopsEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Integer reId;			//发布者ID
	private String province ;		//省份
	private String city ;			//市
	private String arer ;			//区
	private String shName;			//商铺名称
	private Integer shType;			//商铺经营类型（转商铺经营类型表）
	private Integer shRunStatus;	//商铺经营状态（1经营中、2暂停经营）
	private String shAddress;		//商铺详细地址
	private Integer shAcreage;		//商铺面积
	private Integer shAcreageW;		//商铺面积宽
	private Integer shAcreageH;		//商铺面积高
	private Integer shLayerH;		//商铺楼层高度
	private Integer shLayerNum;		//商铺楼层数
	private String shDescribe;		//商铺详细描述
	private Integer shRegionType;	//商铺区域类型（转商铺区域类型表）
	private String shPic;			//商铺图片
	private String shParts;			//商铺配套（转商铺配套）
	private Integer reType;			//发布类型（1转让、2出租）
	private String attornPrice;		//转让价格
	private String rentPrice;		//租出价格（月租）
	private String payMode;			//租出时付款方式
	private Integer spareRentTerm;	//剩余租期
	private Integer reStatus;		//发布状态（1审核中、2审核失败、3审核成功）
	private String reName;			//发布名称
	private String rePhone;			//发布人联系方式
	private Integer onlineStatus;	//在线状态（1在线中、2已下线）
	private String reTime;			//发布时间	
	private String offlineTime;		//下线时间（成功交易时间）
	private Integer watchNum;		//浏览次数
	private String onlineTime;		//上线时间
	private Long managerId;			//管理员ID
	private Integer rcIndex;		//推荐指数（5.广告商铺，2.代理商铺，1.免费商铺）
	private String updateTime;		//更新日期
	
	@Override
	public String toString() {
		return "QyReleaseShopsEntity [id=" + id + ", reId=" + reId + ", shName=" + shName + ", shType=" + shType
				+ ", shRunStatus=" + shRunStatus + ", shAddress=" + shAddress + ", shAcreage=" + shAcreage
				+ ", shAcreageW=" + shAcreageW + ", shAcreageH=" + shAcreageH + ", shLayerH=" + shLayerH
				+ ", shLayerNum=" + shLayerNum + ", shDescribe=" + shDescribe + ", shRegionType=" + shRegionType
				+ ", shPic=" + shPic + ", shParts=" + shParts + ", reType=" + reType + ", attornPrice=" + attornPrice
				+ ", rentPrice=" + rentPrice + ", payMode=" + payMode + ", spareRentTerm=" + spareRentTerm
				+ ", reStatus=" + reStatus + ", reName=" + reName + ", rePhone=" + rePhone + ", onlineStatus="
				+ onlineStatus + ", reTime=" + reTime + ", offlineTime=" + offlineTime + ", watchNum=" + watchNum + "]";
	}
	
	
}
