package com.qiyue.shopsyn.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public interface GlobalConst {

	public static final class Code {
		private static Map<String,String> message = new HashMap<String,String>();
		static{
			message.put(Code.SUCCESS, "success");
			message.put(Code.SUCCESS_SIGN, "success");
			message.put(Code.NO_VIP, "user limit");
			message.put(Code.DEFAULT_USER, "user limit");
			message.put(Code.SUCCESS_NO_WARE, "prize is empty");
			message.put(Code.V_CODE, "need validation code");
			message.put(Code.ERROR, "interface error");
			
			message.put(Code.NEW_SUCCESS, "newSuccess");
			
			message.put(Code.CODE_1001, "fail");
			message.put(Code.CODE_1002, "fail status");
			message.put(Code.CODE_1003, "fail");
			message.put(Code.CODE_1004, "fail status");
			message.put(Code.CODE_1005, "fail status");
			message.put(Code.CODE_1006, "fail status");
			message.put(Code.CODE_1007, "parameter error[mobile]");
			message.put(Code.CODE_1008, "fail status");
			message.put(Code.CODE_1009, "prize limit");
			
			message.put(Code.CODE_1010, "prize is empty");
			message.put(Code.CODE_1011, "config error");
			message.put(Code.CODE_1012, "parameter error");
			message.put(Code.CODE_1013, "frequent operation");
			message.put(Code.CODE_1014, "fail status");
			message.put(Code.CODE_1015, "interface error");
			message.put(Code.CODE_1016, "start");
			message.put(Code.CODE_1017, "fail");
			message.put(Code.CODE_1018, "repeat");
			message.put(Code.CODE_1019, "fail status");
			
			message.put(Code.CODE_1020, "parameter error");
			message.put(Code.CODE_1021, "parameter error");
			message.put(Code.CODE_1022, "system error");
			message.put(Code.CODE_1023, "user limit");
			message.put(Code.CODE_1024, "config error");
			message.put(Code.CODE_1025, "payment error");
			message.put(Code.CODE_1026, "account balance is not enough");
			message.put(Code.CODE_1027, "mobile error");
			
			message.put(Code.DONE, "report");
			message.put(Code.GET_FAIL, "fail");
			message.put(Code.NOTDRAWN, "not winning");
			
			message.put(Code.CODE_1031, "interface code error");
			message.put(Code.CODE_1032, "parameter error");
			message.put(Code.CODE_1033, "account error");
			message.put(Code.CODE_1034, "config error");
			message.put(Code.CODE_1035, "remote interface error");
			message.put(Code.CODE_1036, "user limit");
			message.put(Code.CODE_1037, "config error");
			message.put(Code.CODE_1038, "account balance is not enough");
			message.put(Code.CODE_1039, "config error");
			
			message.put(Code.CODE_1040, "parameter error");
			message.put(Code.CODE_1041, "register error");
			message.put(Code.CODE_1042, "user limit");
			message.put(Code.CODE_1043, "config error");
			message.put(Code.CODE_1044, "config error");
			message.put(Code.CODE_1045, "parameter error");
			message.put(Code.CODE_1046, "parameter error");
			message.put(Code.CODE_1047, "user limit");
			message.put(Code.CODE_1048, "parameter error[userId]");
			message.put(Code.CODE_1049, "user limit[day]");
			
			message.put(Code.CODE_1050, "prize is empty");
			message.put(Code.CODE_1051, "fail");
			message.put(Code.CODE_1052, "parameter error[sign]");
			message.put(Code.CODE_1053, "parameter error");
			message.put(Code.CODE_1054, "user limit");
			message.put(Code.CODE_1055, "config error");
			message.put(Code.CODE_1056, "user limit");
			message.put(Code.CODE_1057, "user limit");
			message.put(Code.CODE_1058, "report");
			message.put(Code.CODE_1059, "config error");
			
			message.put(Code.CODE_1060, "system close");
			message.put(Code.CODE_1061, "config error");
			message.put(Code.CODE_1062, "request method error");
			message.put(Code.CODE_1063, "user info fail");
			message.put(Code.CODE_1064, "province limit");
			message.put(Code.CODE_1065, "user limit");
			message.put(Code.CODE_1066, "user limit");
			message.put(Code.CODE_1067, "config error");
			message.put(Code.CODE_1068, "fail[connect]");
			message.put(Code.CODE_1069, "no old user");
			message.put(Code.CODE_1070, "old user has ware");			
			message.put(Code.CODE_1071, "not pre install user");		
			message.put(Code.CODE_1072, "event expired");
			
			message.put(Code.CODE_1073, "any ware is empty");
			message.put(Code.CODE_1074, "help id is empty");
			
			message.put(Code.CODE_1076, "card pass word is wrong");
			message.put(Code.CODE_1078, "orderId is wrong");
			message.put(Code.CODE_1079, "ware or keynam is wrong");
			message.put(Code.CODE_1081, "interface forbid");
			
			//微服务的请求message返回
//			message.put(Code.MICRO_SUCCESS, "success");
//			message.put(Code.MICRO_FAIL, "fail");
		}
		
		
		public final static String getMessage(String code){
			String msg = message.get(code);
			if(StringUtil.isEmptyString(msg)){
				msg = "fail";
			}
			return msg;
		}
		
		
		public final static String getMessage(String code,String appendMsg){
			String msg = message.get(code);
			return msg + " " + appendMsg;
		}
		
		public final static String SUCCESS = "1"; // 请求成功
		public final static String SUCCESS_SIGN = "2"; // 签到成功，且获得物品
		public final static String NO_VIP = "4"; // 非会员不允许参加
		public final static String DEFAULT_USER = "5"; // 仅限普通用户参加
		public final static String SUCCESS_NO_WARE = "6"; // 请求成功,但是没有获得物品
		public final static String V_CODE = "7"; // 验证码错误
		
		public final static String NEW_SUCCESS = "3";  //新的活动交付流程，成功且获得物品

		public final static String ERROR = "1000"; // 接口异常
		public final static String CODE_1001 = "1001"; // 接口不存在
		public final static String CODE_1002 = "1002"; // 接口暂未开放
		public final static String CODE_1003 = "1003"; // 活动不存在
		public final static String CODE_1004 = "1004"; // 活动暂未开放
		public final static String CODE_1005 = "1005"; // 活动未到开放时间
		public final static String CODE_1006 = "1006"; // 接口未到开放时间
		public final static String CODE_1007 = "1007"; // 手机号不能为空
		public final static String CODE_1008 = "1008"; // 限制范围配置错误
		public final static String CODE_1009 = "1009"; // 您已抢到礼品
		public final static String CODE_1010 = "1010"; // 礼品已经领完
		public final static String CODE_1011 = "1011"; // 接口类型暂不被支持

		public final static String CODE_1012 = "1012"; // 请求参数错误
		public final static String CODE_1013 = "1013"; // 操作过于频繁
		public final static String CODE_1014 = "1014"; // 交付接口已关闭

		public final static String CODE_1015 = "1015"; // 赛程异常
		public final static String CODE_1016 = "1016"; // 比赛已经开始不允许投注
		public final static String CODE_1017 = "1017"; // 人数已满不能参加
		public final static String CODE_1018 = "1018"; // 活动不能重复参加
		public final static String CODE_1019 = "1019"; // 比赛已经结束不允许投注
		public final static String CODE_1020 = "1020"; // 投注数量不能小于0

		public final static String CODE_1021 = "1021"; // 参数错误，结果获取异常
		public final static String CODE_1022 = "1022"; // 系统烦满，稍后重试
		public final static String CODE_1023 = "1023"; // 没活动参加资格
		public final static String CODE_1024 = "1024"; // 接口交付类型不被支持

		public final static String CODE_1025 = "1025"; // 远端支付系统异常

		public final static String CODE_1026 = "1026"; // 元气值不足
		public final static String CODE_1027 = "1027"; // 未绑定手机号
		public final static String DONE = "1028"; // 您已参加过活动
		public final static String GET_FAIL = "1029"; // 物品获取失败
		public final static String NOTDRAWN = "1030"; // 未抽到奖品
		public final static String CODE_1031 = "1031"; // 接口验证码类型错误
		public final static String CODE_1032 = "1032"; // 竞猜队伍错误
		public final static String CODE_1033 = "1033"; // 支付账户不存在
		public final static String CODE_1034 = "1034"; // 接口参数配置错误
		public final static String CODE_1035 = "1035"; // 远程接口调用失败
		public final static String CODE_1036 = "1036"; // 用户标签限制
		public final static String CODE_1037 = "1037"; // 接口物品不存在
		public final static String CODE_1038 = "1038"; // 剩余抽奖次数不够
		public final static String CODE_1039 = "1039"; // 接口类型错误
		public final static String CODE_1040 = "1040"; // 兑换券金额不能大于资格券金额
		public final static String CODE_1041 = "1041"; // 自动注册失败

		public final static String CODE_1042 = "1042"; // 今日答题次数已用完
		public final static String CODE_1043 = "1043"; // 题库不存在
		public final static String CODE_1044 = "1044"; // 题目不存在
		public final static String CODE_1045 = "1045"; // 答按数量错误
		public final static String CODE_1046 = "1046"; // BODY json 错误

		public final static String CODE_1047 = "1047"; // 超过活动获取物品上限
		public final static String CODE_1048 = "1048"; // userid为空（投票）
		public final static String CODE_1049 = "1049"; // 每天投票上限（投票）
		public final static String CODE_1050 = "1050"; // 奖池已空

		public final static String CODE_1051 = "1051"; // IP黑名单
		public final static String CODE_1052 = "1052"; // 非法请求
		public final static String CODE_1053 = "1053"; // 口令错误
		public final static String CODE_1054 = "1054"; // 中奖上限控制
		public final static String CODE_1055 = "1055"; // 货币类型不支持
		public final static String CODE_1056 = "1056"; // 用户已答过该题
		public final static String CODE_1057 = "1057"; // 超过投注上限
		public final static String CODE_1058 = "1058"; // 重复提交

		public final static String CODE_1059 = "1059"; // 题库数量不足
		public final static String CODE_1060 = "1060"; // 系统已关闭
		public final static String CODE_1061 = "1061"; // 配置错误
		public final static String CODE_1062 = "1062"; // 登陆接口
		public final static String CODE_1063 = "1063"; // 获取用户信息失败

		public final static String CODE_1064 = "1064"; // 分省活动限制
		public final static String CODE_1065 = "1065"; // 限制新用户参加
		public final static String CODE_1066 = "1066"; // 物品标签限制
		public final static String CODE_1067 = "1067"; // 没有找到符合要求的奖品
		public final static String CODE_1068 = "1068"; //ip不被允许
		
		public final static String CODE_1069 = "1069";  //没有找到对应的老用户
		public final static String CODE_1070 = "1070";  //已给老用户送话费
		
		public final static String CODE_1071 = "1071";  //非4G+预装用户
		
		public final static String CODE_1072 = "1072";  //非连续签到，广东
		
		public final static String CODE_1073 = "1073";  //多老用户领取-任一物品库存不足
		
		public final static String CODE_1074 = "1074";  //helpID为空
		
		public final static String CODE_1075 = "1075";  //用户6个月内未登录
		
		public final static String CODE_1076 = "1076"; //卡密错误,兑换失败
		public final static String CODE_1077 = "1077"; //助力成功，但是未能达到3的倍数
		
		public final static String CODE_1078 = "1078"; //orderId格式不对，重发卡密短信
		public final static String CODE_1079 = "1079"; //重发卡密短信,类别不对
		public final static String CODE_1080 = "1080"; //重发卡密短信,不存在活动物品领取明细
		public final static String CODE_1081 = "1081"; //被禁止的接口
		public final static String CODE_1082 = "1082"; //被禁止的接口-不在白名单内
		public final static String CODE_1083 = "1083"; //被禁止的接口-咪咕视频验签
		
		public final static String ALREADY_VOTE = "3001";
		public final static String VOTE_NOT_START = "3002";
		public final static String VOTE_IS_END = "3003";
		public final static String VOTE_NOT_EXIST = "3004";
		public final static String IS_NOT_PUBLISH = "3005";
		public final static String IS_END = "3006";
		public final static String DUPLICATE_VOTEITEM = "3007";
		public final static String ILLEGAL_NUMBER = "3008";
		public final static String VOTE_OVER_LIMIT = "3009";// 投票票数超过100w

		public final static String COUNT_LIMIT = "2004";
		public final static String CODE_2005 = "2005"; // 已经被邀请
		public final static String CODE_2006 = "2006"; // 不能邀请自己
		public final static String CODE_2007 = "2007"; // 累计签到次数不足
		public final static String CODE_2008 = "2008"; // 咪豆不足
		public final static String CODE_2009 = "2009"; // 咪钻不足
		public final static String CODE_2010 = "2010"; // 投票数目超过限制
		public final static String CODE_2011 = "2011"; // 记录不存在

		// 4000~4010：短信发送使用
		public final static String CODE_4000 = "4000"; // 短信发送失败
		public final static String CODE_4001 = "4001"; // 发送次数达到上限
		public final static String CODE_4002 = "4002"; // 短信一分钟发一次
		public final static String CODE_4003 = "4003"; // 模板代码不存在
		public final static String CODE_4004 = "4004"; // 来源ID与模板代码中设置不一致
		public final static String CODE_4005 = "4005"; // 短信发送账号为空
		public final static String CODE_4006 = "4006"; // 短信验证码错误
		public final static String CODE_4010 = "4010"; // 请求参数不完整
		
		//新增投票项
		public final static String CODE_4020 = "4020"; // 投票项ID已存在
		public final static String CODE_4021 = "4021"; // 新增投票项失败
		
		//查询投注记录
		public final static String CODE_4030 = "4030"; //参数不完整
		public final static String CODE_4031 = "4031"; //期数不存在
		
		//查询是否存在新用户
        public final static String CODE_4040 = "4040"; //参数不完整
        public final static String CODE_4041 = "4041"; //不存在
        public final static String CODE_4042 = "4042"; //已经领取
        
      //七天体验会员券发放失败
        public final static String CODE_4043 = "4043"; //已经领取
        
        //微服务的code
        public final static Integer MICRO_SUCCESS = 200; //请求成功
        public final static Integer MICRO_FAIL = 404; //请求失败
        
        

	}

	public static final class Message {
		public final static String Success = "Success";
	}

	/**
	 * 接口是否限制时间
	 * 
	 * @author zhangwei
	 *
	 */
	public static final class IsTimeLimit {
		public final static int YES = 0; // 没有时间限制
		public final static int NO = 1; // 有时间限制
	}

	/**
	 * 限制范围
	 * 
	 * @author zhangwei
	 *
	 */
	public static final class RestraintRange {
		public final static int USER_ID_LIMIT = 1; // 用户ID限制
		public final static int MOBILE_LIMIT = 2; // 手机号限制
		public final static int DEVICE_LIMIT = 3; // 设备号限制
		public final static int ACTIVITY_LIMIT = 4; // 活动号限制
	}

	/**
	 * 周期
	 * 
	 * @author zhangwei
	 *
	 */
	public static final class PeriodType {
		public final static int MINUTE = 0; // 分
		public final static int DAY = 1; // 天
		public final static int MONTH = 2; // 月
		public final static int ACTIVITY_PERIOD = 3; // 活动期间
		public final static int INTERFACE = 4; // 接口
		public final static int INTERFACE_OPEN_PERIOD = 5; // 接口开放时间
		public final static int PERIOD_TIME = 10; // 间隔时长
	}

	/**
	 * 物品领取状态
	 * 
	 * @author zhangwei
	 *
	 */
	public static final class WareEUserRelaConstant {
		public final static int WAITING_FOR_RECEIVE = 1; // 待领取
		public final static int RECEIVED = 2; // 已领取
		public final static int RECEIVED_FAILE = 3; // 领取失败
		public final static int WAITING_FOR_DELIVERY = 4; // 待延时交付
		public final static int DELIVERY_REVOKED = 5; // 交付回滚
		public final static int MANUAL_CANCEL = 6; // 人工取消
		public final static int USED = 7; // 已使用
		public final static int EXPIRE_ROLLBACK = 8; // 超时回收

	}

	/**
	 * 营销活动状态
	 * 
	 * @author zhangwei
	 *
	 */
	public static final class ActStatusRela {
		public final static int INITIAL = 0; // 初始化
		public final static int WAITING_FOR_CHECKED = 1; // 待审核
		public final static int TEST = 2; // 测试
		public final static int NORMAL = 3; // 正常
		public final static int CLOSED = 4; // 关闭
		public final static int FAIL = 10; // 审核失败
	}

	/**
	 * 营销活动接口状态
	 * 
	 * @author zhangwei
	 *
	 */
	public static final class IntfStatus {
		public final static int INITIAL = 0;// 初始化
		public final static int STOP = 1;// 正常暂停（定时型可启用）
		public final static int RUN = 2; // 启用
		// 人工暂停状态时，人工通过界面启用时，根据起止时间判断，如果在起止时间范围内，则变为2，否则变为1
		public final static int STOP2 = 3; // 人工暂停(人工暂停，定时型不启用)
	}

	/**
	 * 时间常量
	 * 
	 * @author Krame
	 *
	 */
	public static final class TimeConst {
		public final static int MINUTE = 60; // 秒 1分钟
		public final static int MINUTE5 = 300; // 秒 5分钟
		public final static int MILLISECONDS = 0; // 毫秒 1分钟 60000
		public final static int ZERO = 0; // 0秒，设置不偏移
		public final static int SECOND = 1; // 1秒
		public final static int SECOND2 = 2; // 2秒
		public final static int SECOND10 = 10; // 10秒
		public final static int SECOND5 = 5; // 5秒
		public final static int HOURS = 3600; // 一小时
		public final static int HOURS2 = 7200; // 两小时
		public final static int DAYS = 86400; // 一天
		public final static int SECOND30 = 30; // 30秒
		
		public final static int HALFHOURS = 1800; // 半小时

		// public final static int TEST_FULL_EXPIRETIME = 60;

		public final static int DAYS7 = 604800; // 7天
		public final static int DAYS15 = 1209600; // 15天
		public final static int MONTH = 2419200; // 30天，一月
		public final static int TWOMONTH = 2419200*2; // 60天，2月
	}

	/**
	 * redis key 前缀
	 * 
	 * @author zhangwei
	 *
	 */
	public static final class KeyConst {
		public final static String OT = "OT_"; // 接口开放时间
		public final static String WARE = "WARE_"; // 接口开放时间段內的物品清单
		public final static String WARE_ID = "WARE_ID_"; // 获取当前物品ID
		public final static String RULE = "RULE_"; // 规则ID
		public final static String LIMIT = "LIMIT_"; // 系统配置校验

		public final static String ACTID = "ACTID_"; // 营销活动信息
		public final static String ACT_CODE = "ACT_CODE"; // 营销活动信息
		public final static String INTFID = "INTFID_"; // 接口信息
		public final static String U_WARE = "U_WARE_"; // 用户是否抢到物品

		public final static String PREFIX = "FS:"; // 一秒用户验证
		public final static String IP = "IP_"; // ip拦截

		public final static String PREFIX5 = "FS5:"; // 一秒用户验证
		public final static String IP5 = "IP5_"; // ip拦截

		public final static String INTF_PAY = "INTF_PAY_"; // 接口交付类型

		public final static String GUESS = "GUESS_"; // 趣味竞猜
		public final static String USER_GUESS = "USER_GUESS_"; // 趣味竞猜
		public final static String USER_GUESS_LIST = "USER_GUESS_LIST_"; // 趣味竞猜

		public final static String SCHEDULE = "SCHEDULE_"; // 赛程安排
		public final static String UEFA_GUESS_ITEMS = "UEFA_GUESS_ITEMS"; // 趣味竞猜总人数
		public final static String UEFA_RESULT = "UEFA_RESULT_"; // 比赛结果
		public final static String UEFA_VS_TEAM = "UEFA_VS_TEAM"; // 比赛队伍
		public final static String UEFA_ALL_RESULT = "UEFA_ALL_RESULT"; // 获取所有比赛结果
		public final static String SIGN_IN = "SIGN_IN_"; // 用户连续签到天数
		public final static String SIGN_ED = "SIGN_ED_"; // 用户是否已经获取过7天体验会员
		public final static String SIGN_IN_DAY = "SIGN_IN_DAY_"; // 当前用户是否签到过
		
		public final static String DISCRETE_SIGN_IN = "DISCRETE_SIGN_IN_"; // 用户非连续签到次数


		// public final static String T_AAA_USER = "T_AAA_USER"; // 获取满足送70M流量用户
		// -和视界升级领流量活动
		// public final static String T_AAA_USER_ED = "T_AAA_USER_ED"; //
		// 已经参加过活动的用户列表

		public final static String BETTING_CNT = "BETTING_CNT_"; // 胜负参与人数

		public final static String T_WARE_ACT_OPEN_TIME = "WARE_ACT_OPEN_TIME_"; // 抽奖物品活动关系表

		public final static String USER_WAREPRIZE_HIS = "USER_WAREPRIZE_HIS"; // 抽奖物品活动关系表

		public final static String SCHEDULE_RESULT = "SCHEDULE_RESULT_"; // 赛果

		public final static String UEFA_TEAM_LIST = "UEFA_TEAM_LIST_"; // 比赛队伍

		public final static String T_UEFA_IN = "T_UEFA_IN_"; // 欧洲杯进球福利-通知进球key
		public final static String T_UEFA_AKEY = "T_UEFA_AKEY"; // 进球红包
		public final static String T_UEFA_AKEY_EXISTS = "T_UEFA_AKEY_EXISTS"; // 可以抢购的红包key
		public final static String T_UEFA_HB_GETED = "T_UEFA_HB_GETED_"; // 已获取到红包用户

		public final static String WARE_USER_HASGET_MONTH = "WARE_USER_HASGET_MONTH2_"; // 积分商城-兑换/月
																						// 控制
		public final static String WARE_USER_HASGET_DAY = "WARE_USER_HASGET_DAY2_"; // 积分商城-兑换/天
																					// 控制
		// public final static String WARE_USER_HASGET_YEAR =
		// "WARE_USER_HASGET_YEAR_"; // 积分商城-兑换/天
		// 控制
		public final static String WARE_USER_HASGET_ACT = "WARE_USER_HASGET_ACT_"; // 活动期间

		public final static String VIP_KEY_USER = "VIP_KEY_USER"; // vip用户缓存
		public final static String T_WARE = "T_WARE_";
		public final static String T_INTF_PARAM = "T_INTF_PARAM_"; // 接口配置参数表
		
		public final static String T_INTF_WHITELIST = "T_INTF_WHITELIST_"; // 接口白名单表

		public final static String T_INTF_LABEL_LIMIT = "T_INTF_LABEL_LIMIT_"; // 接口标签
		public final static String T_USER_LABEL = "T_USER_LABEL_"; // 用户标签
		public final static String T_VOTE_LABEL_LIMIT = "T_VOTE_LABEL_LIMIT_"; // 投票标签限制

		public final static String T_INTF_LIMIT_PARAM = "T_INTF_LIMIT_PARAM"; // 分省活动限制
		public final static String T_SEGMENT = "T_SEGMENT"; // 分省号码段

		public final static String USER_VOTE_LAST_TIME = "USER_VOTE_LAST_TIME_"; // 用户最后一次投票时间
		public final static String VOTE_ITEM = "VOTE_ITEM"; // 投票选项信息
		public final static String VOTE_ITEM_COUNT = "VOTE_ITEM_COUNT_"; // 用户投票信息
		public final static String VOTE_ID = "VOTE_ID_"; // 投票信息
		public final static String VOTE_ID_VOTE_ITEM_RELA = "VOTE_ID_VOTE_ITEM_RELA_"; // 投票选项信息
		public final static String VOTE_ID_VOTE_FULL = "VOTE_ID_VOTE_FULL_"; // 投票选项信息
		public final static String USER_VOTE_BY_VOTEID = "USER_VOTE_BY_VOTEID_"; // 用户投票信息
		public final static String VOTE_ITEM_CNT = "VOTE_ITEM_CNT_"; // 投票项的投票信息
		public final static String VOTE_INFO_PARAM = "VOTE_INFO_PARAM_"; // 投票参数信息

		public final static String CARD_PLATFORM = "CARD_PLATFORM_"; // 卡平台兑换状态
		public final static String TEST_DAY_HIS = "TEST_DAY_HIS_"; // 用户当日答题情况
		public final static String TEST_CAT_FULL = "TEST_CAT_FULL2_"; // 题库
		public final static String TEST_BY_CATID = "TEST_BY_CATID"; // 根据catId获得对应题库
		public final static String TEST_ITMES_FULL = "TEST_ITEMS_FULL_"; // 答题项
		public final static String TEST = "TEST_"; // 答题
		public final static String TEST_CAT = "TEST_CAT_"; // 答题
		public final static String TEST_ITEM_RELA = "TEST_ITEM_RELA_"; // 正确答案
		public final static String TEST_KEY_VAULE_PAIR = "TEST_KEY_VAULE_PAIR"; // 题目固定的答题项
		public final static String TEST_BY_TEST_ID = "TEST_BY_TEST_ID"; // 根据题目id获取题目

		public final static String ACT_WARE_LIMIT = "ACT_WARE_LIMIT_"; // 活动和物品限制条件
		public final static String INTF_LABEL_RELA = "INTF_LABEL_RELA_"; // 活动和物品限制条件
		public final static String CURRENT_MINUTE_WARE_COUNT = "CURRENT_MINUTE_WARE_COUNT_"; // 一分钟内用户领取的奖品数
		public final static String CURRENT_DAY_WARE_COUNT = "CURRENT_DAY_WARE_COUNT_"; // 一天内用户领取的奖品数
		public final static String CURRENT_MONTH_WARE_COUNT = "CURRENT_MONTH_WARE_COUNT_"; // 一月内用户领取的奖品数
		public final static String CURRENT_ACTIVITY_WARE_COUNT = "CURRENT_ACTIVITY_WARE_COUNT_"; // 活动期间用户领取的奖品数
		public final static String CURRENT_INTF_WARE_COUNT = "CURRENT_INTF_WARE_COUNT_"; // 接口期间用户领取的奖品数
		public final static String USER_CORP_TEST_BRANCH_AMOUNT = "USER_CORP_TEST_BRANCH_AMOUNT_"; // 接口期间用户领取的奖品数
		public final static String USER_CORP_TEST_CONTENT_AMOUNT = "USER_CORP_TEST_CONTENT_AMOUNT_"; // 接口期间用户领取的奖品数
		public final static String PAY_ACCOUNT_COUNT = "PAY_ACCOUNT_COUNT"; // 接口期间用户领取的奖品数
		public final static String CORP_TEST_CONTENT_VOTE_RECORD = "CORP_TEST_CONTENT_VOTE_RECORD_"; // 接口期间用户领取的奖品数

		public final static String INVITE = "INVITE_"; // 邀请用户缓存

		public final static String VOTE_ALL_CNT = "VOTE_ALL_CNT"; // 累计票数
		public final static String VOTE_DAY_CNT = "VOTE_DAY_CNT"; // 当日票数
		// public final static String VOTE_USER_DAY_CNT = "VOTE_USER_DAY_CNT";
		// //用户每日统计
		// public final static String VOTE_USER_LIST = "VOTE_USER_LIST"; //我的投票
		public final static String T_CLAIM_INFO = "T_CLAIM_INFO"; // 赔付记录
		public final static String T_VOTE_LOG = "T_VOTE_LOG"; // 开奖记录
		public final static String T_VOTE_LOG_BYTYPE = "T_VOTE_LOG_BYTYPE"; // 开奖记录
		public final static String T_CLAIM_INFO_LUCKY = "T_CLAIM_INFO_LUCKY"; // 每日幸运奖开奖记录

		public final static String T_DISCRETE_SIGN_IN = "T_DISCRETE_SIGN_IN_"; // 非连续签到记录
		public final static String T_INTF_USER_WAREV2 = "T_INTF_USER_WAREV2"; // 用户接口物品限制
		public final static String T_INTF_USER_LIMIT_WAREV2 = "T_INTF_USER_LIMIT_WAREV2"; // 用户接口物品限制
		public final static String T_USERID_CACHE = "T_USERID_CACHE_"; // userid缓存
		public final static String T_SOURCE_IP_CACHE = "T_SOURCE_IP_CACHE_"; // sourceip缓存

		public final static String T_IMAGE_CODE = "T_IMAGE_CODE"; // 验证码缓存
		public final static String T_DAY_IP_COUNTS = "T_DAY_IP_COUNTS"; // IP缓存

		public final static String T_VOTE_COUNTS = "T_VOTE_COUNTS"; // 投票赛次数控制
		public final static String T_TOKEN = "T_TOKEN"; // TOKEN
		public final static String T_VISITOR = "T_VISITOR"; // T_VISITOR
		public final static String T_INTF_SECRET_KEY = "T_INTF_SECRET_KEY"; // 接口密钥
		public final static String T_PA_WARE = "T_PA_WARE";

		// add
		public final static String T_INTF_BODYLABEL_LIMIT = "T_INTF_BODYLABEL_LIMIT"; // 转赠白名单标签限制
		public final static String T_USER_LABEL_RELA = "T_USER_LABEL_RELA"; // 用户标签中间表

		public final static String T_ACT_WARE_LIMIT = "T_ACT_WARE_LIMIT";
		public final static String T_INTF_WARE_LIMIT = "T_INTF_WARE_LIMIT"; // 接口物品获取总量限制

		public final static String T_ACT_INTF_OPEN_TIME = "T_ACT_INTF_OPEN_TIME"; // 活动接口开放时间范围表

		public final static String T_U_WARE = "T_U_WARE"; // 用户是否抢到物品
		// 答题类：题目
		public final static String TQ_TEST = "TQ_TEST"; // 用户是否抢到物品
		public final static String INTF_ALL_CNT = "INTF_ALL_CNT"; // 接口中奖物品次数

		public final static String TQ_USER_ANSWER_REC = "TQ_USER_ANSWER_REC"; // 用户答题记录表

		public final static String WIN_NUM = "WIN_NUM"; // 每个用户对应的中奖号码
		public final static String LOTTERYLABELLIMIT = "LOTTERYLABELLIMIT";
		public final static String INTF_USER_CNT = "INTF_USER_CNT"; // 用户参加活动次数
		public final static String INTF_USER_TODAY_CNT = "INTF_USER_TODAY_CNT"; // 用户参加活动次数
		public final static String INTF_USER_MONTH_CNT = "INTF_USER_MONTH_CNT"; // 用户参加活动次数
		public final static String T_WARE_E_USER_RELA = "T_WARE_E_USER_RELA"; // 获取用户订单信息
		public final static String T_WARE_E_USER_RELA_NOTICE = "T_WARE_E_USER_RELA_NOTICE"; // 显示公告

		public final static String T_LOTTERY_LABEL_LIMIT = "T_LOTTERY_LABEL_LIMIT"; // 获取开奖标签限制
		public final static String VIP_USER_INFO = "VIP_USER_INFO"; // vip用户信息

		public final static String T_WARE_E_USER_RELA_DETAIL = "T_WARE_E_USER_RELA_DETAIL"; // 用户参加某一活动获得所有物品

		public final static String T_WARE_E_USER_RELA_PARAM = "T_WARE_E_USER_RELA_PARAM"; // 获取用户订单信息
		public final static String T_WARE_E_USER_RELA_NOTICE_PARAMV2 = "T_WARE_E_USER_RELA_NOTICE_PARAMV2"; // 显示公告

		public final static String T_GLOBAL = "T_GLOBAL";
		public final static String TEST_CAT_BY_PK = "TEST_CAT_BY_PK";
		public final static String PA_WARE = "PA_WARE";

		public final static String T_TEST_INFO = "T_TEST_INFO";
		public final static String T_NEW_YEAR_WARE_CNT = "T_NEW_YEAR_WARE_CNT";

		public final static String T_BODY_DIS = "T_BODY_DIS";

		public final static String PAY_ACCOUNT_COUNT_ACT = "PAY_ACCOUNT_COUNT_ACT"; // 接口期间用户领取的奖品数
		public final static String T_USER_VOTE_INFO = "T_USER_VOTE_INFO";
		public final static String SMS_SIGN = "SMS_SIGN";

		public final static String STM_T_TOP_10_ACT = "STM_T_TOP_10_ACT"; // 获得最新参加活动的用户
		public final static String PM_SMS_CODE_TIMES = "PM_SMS_CODE_TIMES"; //
		public final static String PM_SMS_CODE = "PM_SMS_CODE"; // 短信验证码
		public final static String PM_SMS_CODE_TTL = "PM_SMS_CODE_TTL";
		public final static String T_MSG_PARAM = "T_MSG_PARAM";
		public final static String T_MSG_ACCOUNT = "T_MSG_ACCOUNT";

		public final static String E_ERROR_CODE_CNT = "E_ERROR_CODE_CNT";
		public final static String ACT_ORDER = "ACT_ORDER"; // 订单
		public final static String T_ACT_VISIT_2_DAY_INFO = "T_ACT_VISIT_2_DAY_INFO"; // 最近三天的订单数据
		public final static String T_MSG_TEMPLATE = "T_MSG_TEMPLATE"; // 短信模版
		public final static String TA_VOTE_INFO_PARAM = "TA_VOTE_INFO_PARAM";
		public final static String T_WARE_ACT_OPEN_TIME_PARAM = "T_WARE_ACT_OPEN_TIME_PARAM";
		public final static String T_WARE_ACT_OPEN_TIME_CHECK = "T_WARE_ACT_OPEN_TIME_CHECK";
		
		public final static String T_COUPON_INFO = "T_COUPON_INFO"; //coupon短信发送记录
		
		public final static String NEXT_OPEN_TIME = "NEXT_OPEN_TIME_"; // 活动下一次开放时间
		public final static String WHITE_IP = "WHITE_IP"; //IP白名单
		public final static String ORDERS = "ORDERS";
		public final static String BLACK_IP = "BLACK_IP"; //IP黑名单
		
		public final static String T_PA_INTF_LIST = "T_PA_INTF_LIST";
		
		public final static String GKE_SCHEDULE = "GKE_SCHEDULE";
		public final static String GKE_BETTING_REC = "GKE_BETTING_REC";
		public final static String GKE_BETTING_WIN = "GKE_BETTING_WIN";
		public final static String GKE_BETTING_PUT = "GKE_BETTING_PUT";
		
		public final static String MOBILE_RELA = "MOBILE_RELA_";
		public final static String SHARE_NEW_USER_MOBILE = "SHARE_NEW_USER_MOBILE";
		public final static String QUERY_LABEL_MOBILE = "QUERY_LABEL_MOBILE";
		public final static String QUERY_LABEL_USERID = "QUERY_LABEL_USERID";
		
		public final static String T_USER_INTF_REDIS = "T_USER_INTF_REDIS_"; 
		
		public final static String T_ABNORMAL_TOKEN_KEY = "T_ABNORMAL_TOKEN_KEY_"; 
		
		public final static String T_INTF_USER_QTEST_ITEM = "T_INTF_USER_QTEST_ITEM_";
		//add by xjm
		public final static String T_LOTTERY_CONFIG = "T_LOTTERY_CONFIG_";
		public final static String T_LOTTERY_CONFIG_DETAIL = "T_LOTTERY_CONFIG_DETAIL_";
		
		public final static String INCLUDE_INTF = "INCLUDE_INTF_"; // 获得当前时间段该用的intfId
		
		public final static String MANY_MOBILE_RELA = "MANY_MOBILE_RELA_"; 
	}

	/**
	 * 接口处理类型
	 * 
	 * @author zhangwei
	 *
	 */
	public static final class IntfType {
		public final static String SNAP_UP = "1"; // 秒杀类型
		public final static String SIGN_IN = "2"; // 签到类型
		public final static String DEFAULT = "3"; // 通用类型
		public final static String DRAW = "4"; // 抽奖类型
		public final static String DEFAULT_PAY = "5"; // 默认交付
		public final static String TEST = "7"; // 答题类型
		public final static String CORP_TEST = "8"; // 集团投票
		public final static String INVITE = "9"; // 邀请类型
		public final static String DISCRETE_SIGN_IN = "10"; // 非连续签到类型
		public final static String DISCRETE_SIGN_IN_PROCESS = "11"; // 非连续签到处理类型
		public final static String DELIVERY_ACTIVITY = "12"; //xjm 交付活动类型
		// public final static String WENHUA = "12";
	}

	/**
	 * 接口交互类型
	 * 
	 * @author zhangwei
	 *
	 */
	public static final class IntfPayType {

		public class Http {
			public final static int NO = 0; // HTTP-不pay
			public final static int JIANGXIMALASONG = 8;// 江西马拉松
			public final static int INTEGRALDRAW_V2 = 9; // 积分抽奖2期
			public final static int SCORE = 10; // 积分
			public final static int EXCHANGE_V2 = 11; // 积分兑换2期
			public final static int KAFKA = 15; // kafka读取t_ware表自动交付
			public final static int SIGN_IN = 16; // 签到交付
			public final static int BARRAGE = 18; // 弹幕交付
			public final static int PHONE_CHARGE = 19; // 话费礼券交付
			public final static int INTEGRALDRAW_V3 = 20; // 必中抽奖
			public final static int VIPCOUPON = 21; // 体验会员券兑换
			public final static int GUANGDONG_OLYMPIC = 23; // 广东奥运会
			public final static int DELIVERY_NORMAL = 24; // 被交付接口普通交付类型
			public final static int KAFKA_PROBABILITY = 25; // kafka 概率交付
			public final static int KAFKA_LIST = 26; // KAFKA多物品交付
			public final static int SECRET = 27; // 口令交付
			public final static int TRANSFER = 28; // 积分转赠
			public final static int DISCRETESIGNIN = 29; // 非连续签到 【多周期】
			public final static int KAFKARANDOMONE = 30; // KAFKA随机获取单个物品
			public final static int DISCRETESIGNIN_ONE = 31; // 非连续签到单周期
			public final static int SECRET_OPEN_TIME_WARE = 32; // 口令交付[开放时间物品]
			public final static int SIGN_IN_V2 = 33; // 签到交付V2，连续签到
			public final static int INTEGRALDRAW_V2_NEW = 34; // 抽奖V2 新版
			public final static int RAIDER_OF_PUBLIC = 35; // 夺宝众筹
			public final static int PAYMENT_TEST = 36;  //答题类型

			public final static int PAYMENT_H5 = 37;// 春节红包交付
			public final static int NEWYEAR_DRAW = 38; // 春节集福抽奖
			public final static int EXCHANGE_PROM = 39; // 资格券兑换
			public final static int DRAW100 = 40; // 必中抽奖
			public final static int DRAW2017 = 41; // 2017抽奖
			
			public final static int TRANS = 43; //透传类型

			// public final static int WENHUA_FLOW = 43; //同步交付：咪咕文化流量抢
			// public final static int WENHUA_MIGUCOIN = 44; //同步交付：咪咕币交付
			public final static int COLLECT_DRAW = 45; //集福开奖类型
			//江苏新老用户分享
			public final static int SHARE_NEW_USER = 46; //分享新用户
			public final static int OLD_USER_KAFKA_LASTONE = 47; //老用户领取物品
			
			public final static int CMTV_RED_ENVELOPE = 48; //直播红包雨
			
			public final static int REDUCE_COUPON_KAFKA_LIST = 49;//扣券领取多物品
			
			public final static int DELIVERY_RAIDER_OF_PUBLIC = 50;//xjm 交付夺宝众筹类型
			
			public final static int PRE_INSTALL_ITEM = 51;//xjm 4G+用户领取类型
			
			public final static int MANY_OLD_USER_KAFKA_LIST = 52; //xjm 所有老用户领取物品
			
			public final static int SEVEN_DAYS_VIP_RECHARGE = 53; //7天体验会员券 
			
			public final static int SHANG_XI_HUA_FEI = 54; //陕西充话费接口
			
			public final static int CARD_PASSWORD_LIST =55;//卡密兑换物品
			
			public final static int INVITE_USER_WON_PRIZE =56; //邀请用户获奖
			
			//口令夺宝 add by zhenzhen
			public final static int PASSWORD_WIN_AWARD =57;// 口令夺宝活动 
		}

		public class Kafka {
			public final static int KAFKA = 22; // kafka交付
			public final static int SHARE = 42; // 分享类型交付
		}

		public class Delivery {
			public final static int UNTREATED = 17; // 交付-不处理
		}
	}

	/**
	 * 用户有效请求状态
	 * 
	 * @author zhangwei
	 *
	 */
	public static final class ValidReqOpStatus {
		public final static int INIT = 0; // 初始化
		public final static int WAIT = 10;// 待赠送
		public final static int PROCESSED = 20; // 已处理
		public final static int CANCEL = 30;// 已处理不赠送
	}

	/**
	 * 设备类型
	 * 
	 * @author zhangwei
	 *
	 */
	public static final class Devices {
		public final static int IOS = 1; // IOS
		public final static int Android = 2; // Android
		public final static int OTHER = 3; // 其他
	}

	/**
	 * 
	 * @author zhangwei
	 *
	 */
	public static final class Value {
		public final static String zero = "0";
		public final static String value = "1"; // 由于redis的value不允许为null，防刷时存储一个1，可以减少内存占用
		public final static String day7 = "7"; // 7天送体验会员
		public final static Integer val_5000 = 5000;
		public final static String day3 = "3"; // 3天送观影卷

		public static final String DEFUALTNULL = "";
		public final static String inited = "1"; // 是否初始化完成
	}

	public static final class OpStatus {
		public final static Integer open = 1; // 打开
		public final static Integer close = 2; // 关闭
	}

	/**
	 * 赛程状态
	 * 
	 * @author zhangwei
	 *
	 */
	public static final class ScheduleStatus {
		public final static Integer INIT = 1; // 未开始
		public final static Integer START = 2; // 开始
		public final static Integer DONE = 3; // 结束
	}

	/**
	 * 下注需要扣积分，去订单系统扣积分 1：待支付 2：支付失败 3：支付完成
	 * 
	 * @author zhangwei
	 *
	 */
	public static final class PayStatus {
		public final static Integer INIT = 1;
		public final static Integer FAILE = 2;
		public final static Integer SUCCESS = 3;
	}

	/**
	 * 赢了需要充值积分 1：待赔付 2：失败 3：成功
	 * 
	 * @author zhangwei
	 *
	 */
	public static final class ClaimStatus {
		public final static Integer INIT = 1;
		public final static Integer FAILE = 2;
		public final static Integer SUCCESS = 3;
	}

	/**
	 * 竞猜状态
	 * 
	 * @author zhangwei
	 *
	 */
	public static final class GuessStatus {
		public final static Integer INIT = 1;
		public final static Integer FAILE = 2;
		public final static Integer SUCCESS = 3;
		public final static Integer CANCEL = 4;
	}

	public static class ResultCode {
		public final static String SUCCESS = "SUCCESS"; // 交付执行成功
		public final static String FAILED = "FAILED"; // 交付执行失败
		public final static String ACCEPTED = "ACCEPTED"; // 交付执行已经被急售，但仍在处理（用于异步交付模式）
		public final static String REVOKE_SUCCESS = "REVOKE_SUCCESS"; // 回收成功
		public final static String REVOKE_FAILED = "REVOKE_FAILED"; // 回收失败
		public final static String REVOKE_ACCEPTED = "REVOKE_ACCEPTED"; // 交付回收已经被接收，当仍在处理（用于异步回收模式）
		public final static String ERR_DUPLCATE_DELIVERY_I = "ERR_DUPLCATE_DELIVERY_I"; // deliveryId交付流水号重复
	}

	public static final class DeliveryStatus {
		public final static String WAIT_2_DELIVERY = "WAIT_2_DELIVERY"; // 等待交付（默认状态）
		public final static String DELIVERY_SUCCESS = "DELIVERY_SUCCESS"; // 交付执行成功
		public final static String DELIVERY_FAILED = "DELIVERY_FAILED"; // 交付失败
		public final static String DELIVERY_ACCEPTED = "DELIVERY_ACCEPTED"; // 交付请求已被接收，但仍在处理（用于异步交付模式）
		public final static String REVOKE_FALIDE = "REVOKE_FALIDE"; // 回收失败
		public final static String REVOKE_ACCEPTED = "REVOKE_ACCEPTED"; // 回收请求已被接收，但仍在处理（用于异步回收模式）
	}

	public static final class DeliveryStrategy {
		public final static String ONLY_MAIN = "ONLY_MAIN"; // 当主交付成功后立即返回通知（default）
		public final static String ALL = "ONLY_MAIN"; // 当全部交付成功后才返回通知。
	}

	public static final class Data {
		public static final String RESOURCE_ID = "member_trial";
		public static final String RESOURCE_TYPE = "MEMBER_ID";
	}

	public static final class MovieCarItem {
		public static final String DESC = "3元电影卡"; // 描述
		public static final String HANDLER = "MIGU_MOVIE_CARD"; // 交付执行系统枚举
	}

	public static final class DeliveryRequest {
		public static final String EXTERNALCODE = "Promactivity";
	}

	public static final class AAAUserStauts {
		public static final int UNCOMMITTED = 1; // 未参加
		public static final int COMMITTED = 2; // 已参加
		public static final int INTESTABLE = 3; // 无资格
	}

	/**
	 * 物品
	 * 
	 * @author zhangwei
	 *
	 */
	public static final class Ware {
		public static final String FLOW_70FEE = "1"; // 70m流量
		public static final String VIP_7 = "2"; // 7天体验会员
		public static final String SCORE_100 = "3"; // 100积分
		public static final String SCORE_50 = "4"; // 50积分
		public static final String GYJ = "5"; // 观影卷
	}

	public static final class UefaService {
		public static final String PAYMENTCODE = "_SCORE_PAY";
		public static final String CHANNELID = "promactivity";
	}

	public static final class MemberInfo {
		public static final String MIGU_VIDEO_OFFICIAL_MEMBER = "migu_video_official_member";
		public static final String MIGU_VIDEO_TEMPORARY_MEMBER = "migu_video_temporary_member";
	}

	public static final class MemberType {
		public static final String trial = "trial"; // 体验会员
		public static final String normal = "normal"; // 普通会员
		public static final String olympic_16 = "olympic_16"; // 16奥运会员

		public static final String diamond = "diamond"; // 钻石会员(原普通会员,normal)
		public static final String golden = "golden"; // 黄金会员(原v+会员,vplus)
		public static final String black_diamond = "black_diamond"; // 黑钻会员
		public static final String province_biz_gansu = "province_biz_gansu"; // 甘肃分省会员
		public static final String province_biz_guangdong = "province_biz_guangdong"; // 广东分省会员
		//新增
		public static final String migu_dazhanbao = "migu_dazhanbao"; //钻石会员-大站包 
		public static final String v15 = "v15"; //v15会员
		public static final String tv_family = "tv_family"; //家庭tv产品会员
		

		public static Set<String> vips = new HashSet<String>();
		static {
			vips.add(diamond);
			vips.add(black_diamond);
			vips.add(migu_dazhanbao);
			vips.add(golden);
			vips.add(v15);
			vips.add(province_biz_gansu);
			vips.add(province_biz_guangdong);
		}

	}

	/**
	 * 
	 * @ClassName: AccountType
	 * @Description: 账户类型
	 * @author 宫德宝
	 * @date 2016年5月20日 下午3:28:19
	 *
	 */
	public static final class AccountType {
		public static final String SCORE = "SCORE"; // 积分
		public static final String CMVIDEO_SCORE = "CMVIDEO_SCORE"; // 咪咕视频积分
		public static final String CMMOVIE_SCORE = "CMMOVIE_SCORE"; // 咪咕影院积分
		public static final String CMTV_SCORE = "CMTV_SCORE"; // 咪咕直播积分
		public static final String CMMOVIE_COUPON_PAY = "CMMOVIE_COUPON_PAY";
	}

	/**
	 * 有无验证码
	 * 
	 * @author zhangwei
	 *
	 */
	public final static class HasCode {
		public final static Integer YES = 0; // 有验证码
		public final static Integer NO = 1; // 无验证码
	}

	/**
	 * 欧洲杯配置
	 * 
	 * @author zhangwei
	 *
	 */
	public final static class UEFA {
		public final static String END_TIME = "2016-07-15 00:00:00"; // 欧洲杯结束时间
	}

	/**
	 * 支付返回代码
	 * 
	 * @author zhangwei
	 *
	 */
	public final static class PayResultCode {
		public final static String ACCEPTED = "ACCEPTED"; // 请求正常接收无异常(不代表业务成功)
		public final static String ERR_USER_NOT_VALID = "ERR_USER_NOT_VALID"; // 用户状态异常
		public final static String ERR_CURRENCY_NOT_EXIST = "ERR_CURRENCY_NOT_EXIST"; // 支付账户不存在
		public final static String ERR_BALANCE_LACK = "ERR_BALANCE_LACK"; // 余额不足
	}

	public final static int PROBLITY_MAX = 100000000;

	public final static class IntegralDrawWareNeedUserStatus {
		public final static int VIP_ONLY = 0;// 仅限VIP
		public final static int NORMAL_ONLY = 1;// 仅限普通用户
		public final static int BOTH = 2;// 均可

	}

	public final static class IntegralDrawPrizeStatus {
		public final static String PAY_FAILED = "PAY_FAILED"; // 支付失败
		public final static String MISS = "MISS"; // 未抽中
		public final static String WARE_EMPTY = "WARE_EMPTY"; // 抽中奖品已售罄
		public final static String MONTH_PAID = "MONTH_PAID"; // 当月领取过该奖品
		public final static String VIP_NEEDED = "VIP_NEEDED"; // 仅VIP用户可领取
		public final static String NOT_FOR_VIP = "NOT_FOR_VIP"; // 不对VIP用户开放，进队普通用户开放
		public final static String WIN = "WIN"; // 不对VIP用户开放，进队普通用户开放
	}

	// //认证用户类型：0：用户ID,1：手机号码,2：Email,3：微博,4：支付宝,5：QQ,6：能力开放,7：异网手机号码,8：微信
	public final static class AAAAuthType {
		public final static int USER_ID = 0;
		public final static int MOBILE = 1;
		public final static int EMAIL = 2;
		public final static int WEIBO = 3;
		public final static int ALIPAY = 4;
		public final static int QQ = 5;
		public final static int ABILITY = 6;
		public final static int NOT_CHINA_MOBILE = 7;
		public final static int WEIXIN = 8;
	}

	public final static String UserManageEndpointAddress_LOCAL = "http://211.136.119.112:10080/BRM-ITV-ADAPTER/services/UserManage";
	public final static String UserManageEndpointAddress_ONLINE = "http://172.16.9.197:58080/BRM-ITV-ADAPTER/services/UserManage";

	/**
	 * 是否vip
	 * 
	 * @author zhangwei
	 *
	 */
	public final static class Vip {
		public final static int YES = 1;
		public final static int NO = 2;
	}

	/**
	 * 判断条件1：是 2：否
	 * 
	 * @author zhangwei
	 *
	 */
	public final static class Flag {
		public final static String JIFEN = "1"; // 扣积分
		public final static String NO = "2"; // 不扣
		// public final static String PAYMENT = "3"; //UserDeliveryRela抽奖积分已废弃
		public final static String ACCOUNT_CHANCE = "4"; // 账户系统抽奖机会
		public final static String PRO_WARE = "5"; // 营销平台抽奖机会
		public final static String JIAOPIAN = "6"; // 扣影院胶片
	}

	public final static class IntfParam {
		public final static String PAY_SCORE = "1"; // 是否需要扣积分
		public final static String PAY_VAL = "2"; // 扣减分值
		public final static String SCORE_VAL = "4";// 分值
		public final static String DESC = "5"; // 积分充值描述信息
		public final static String FROM = "6"; // 来源
		public final static String EXPIRYDATE = "7"; // 失效时间
		public final static String CYCLE = "8"; // 积分兑换限制周期
		public final static String COUPON_PRODUCT_ID = "9";// 优惠券产品id
		public final static String COUPON_PRODUCT_AMOUNT = "10";// 优惠券数量
		public final static String ZSFJ_SUB_TYPE = "12"; // 掌上福建产品类型
		public final static String WARE = "13"; // 物品
		public final static String FROM_APP = "14"; // 来源app
		public final static String CYCLE15 = "15"; // KAFKA 交付限制周期
		public final static String SCORE_CYCLE = "16"; // 积分兑换限制周期

		public final static String BARRAGE_SCORE = "17";// 是否需要扣减积分
		public final static String BARRAGE_SCORE_VAL = "18"; // 扣减分值
		public final static String BARRAGE_SCORE_CYCLE = "19"; // 扣减分值
		public final static String BARRAGE_NUMBER_XZ = "20"; // 是否限制数量

		public final static String KAFKA_EXPIRYDATE = "21"; // kafka交付物品失效时间

		public final static String SIGN_DAY = "3";// 连续签到天数
		public final static String SIGN_DAY2 = "22"; // 连续签到周期2
		public final static String SIGN_DAY3 = "23"; // 连续签到周期3
		public final static String SIGN_DAY4 = "26";// 连续签到天数4
		public final static String SIGN_DAY5 = "27"; // 连续签到周期5
		public final static String SIGN_DAY6 = "28"; // 连续签到周期6
		public final static String SIGN_DAY7 = "29";// 连续签到天数7

		public final static String CYCLE24 = "24"; // 抽奖必中 交付限制周期

		public final static String TEST_CAT_ID = "25"; // 答题题库id

		public final static String NEED_ROLL_BACK = "30"; // 需要超时回抽奖池子

		public final static String VIP_COUPON_CODE = "31";// 优惠券代码
		public final static String EXCHANGE_PAY_TYPE = "32";// 连续签到天数7

		public final static String CORP_TEST_BRANCH_MAX = "33";// 集团投票本机构最高每日票数
		public final static String DRAW_STOP_AT_EMPTY = "34";// 奖池空后停止投票

		public final static String CONFIRM_USED = "35";// 确认使用
		public final static String PAY_ACCOUNT_LIMIT = "36";// 确认使用

		public final static String CYCLE37 = "37"; // KAFKA概率交付限制周期
		public final static String CYCLE38 = "38"; // KAFKA多物品交付限制周期
		public final static String CYCLE39 = "39"; // 口令交付限制周期

		public final static String DISCRETE_SIGN_DAY1 = "41";// 连续签到天数1
		public final static String DISCRETE_SIGN_DAY2 = "42"; // 连续签到周期2
		public final static String DISCRETE_SIGN_DAY3 = "43"; // 连续签到周期3
		public final static String DISCRETE_SIGN_DAY4 = "44";// 连续签到天数4
		public final static String DISCRETE_SIGN_DAY5 = "45"; // 连续签到周期5
		public final static String DISCRETE_SIGN_DAY6 = "46"; // 连续签到周期6
		public final static String DISCRETE_SIGN_DAY7 = "47";// 连续签到天数7

		public final static String CYCLE48 = "48"; // KAFKA随机获取物品

		public final static String DISCRETE_SIGN_ONE_DAY = "49";// 非连续签到单周期
		public final static String CYCLE50 = "50"; // 口令交付限制周期

		public final static String CYCLE51 = "51"; // 交付接口限制周期

		public final static String PAY_SCORE_NEW = "52";// 是否需要扣积分
		public final static String PAY_VAL_NEW = "53"; // 扣减分值
		public final static String FROM_APP_NEW = "54"; // 来源app
		public final static String WARE_NEW = "55"; // 物品
		public final static String CYCLE56 = "56"; // 限制周期

		public final static String SIGN_DAY1_NEW = "57";// 连续签到天数1
		public final static String SIGN_DAY2_NEW = "58"; // 连续签到周期2
		public final static String SIGN_DAY3_NEW = "59"; // 连续签到周期3
		public final static String SIGN_DAY4_NEW = "60";// 连续签到天数4
		public final static String SIGN_DAY5_NEW = "61"; // 连续签到周期5
		public final static String SIGN_DAY6_NEW = "62"; // 连续签到周期6
		public final static String SIGN_DAY7_NEW = "63";// 连续签到天数7

		public final static String RAIDER_PUBLIC_CYCLE = "64";// 夺宝众筹限制周期
		public final static String RAIDER_PUBLIC_PAY_TYPE = "65";// 夺宝众筹支付方式
		public final static String RAIDER_PUBLIC_MONEY = "66";// 夺宝众筹货币类型

		public final static String TRUE_TEST_CNT = "67"; // 最少正确答案数

		public final static String TEST_CYCLE = "68";
		public final static String TEST_MAX = "69";
		public final static String TEST_MIN = "70";

		public final static String NEWYEAR_RED_ENVELOPE_LIMIT = "72"; // 春节红包交付限制周期

		public final static String NEWYEAR_PAY = "73"; //集福抽奖-扣除类型
		public final static String NEWYEAR_PAY_VAL = "74"; //集福抽奖-扣减分值
		public final static String NEWYEAR_FROM = "75"; //集福抽奖- 来源
		public final static String NEWYEAR_WARE = "76"; //集福抽奖- 扣除机会
		public final static String NEWYEAR_CYCLE = "77"; //集福抽奖- 限制周期
		public final static String NEWYEAR_CNT_1 = "78"; //集福抽奖- 集福数
		public final static String NEWYEAR_CNT_LABEL = "79"; // 集福数 - 回写标签
		public final static String NEWYEAR_WARE_CYCLE = "85"; // 集福抽奖-奖品限制周期
//		public final static String NEWYEAR_CNT_3 = "80"; // 集福数
//		public final static String NEWYEAR_CNT_4 = "81"; // 集福数
//		public final static String NEWYEAR_CNT_5 = "82"; // 集福数
//		public final static String NEWYEAR_CNT_6 = "83"; // 集福数
//		public final static String NEWYEAR_CNT_7 = "84"; // 集福数		
		

		public final static String PROM_CYCLE = "86";// 限制周期
		public final static String PROM_EFEC = "87"; // 资格券有效期
		public final static String PROM_WARE = "88"; // 资格券代码

		public final static String CY_CYCLE = "89"; // 必中抽奖, 限制周期
		public final static String CJ_PAY_TYPE = "90"; // 必中抽奖，扣除类型
		public final static String CJ_MONEY = "91"; // 必中抽奖，扣除机会
		public final static String CY_APP = "92"; // 必中抽奖，所属APP

		public final static String CY_CYCLE_2017 = "93"; // 2017抽奖 限制周期
		public final static String CY_PAY_TYPE_2017 = "94"; // 2017抽奖，扣除类型
		public final static String CY_MONEY_2017 = "95"; // 2017抽奖，扣除机会
		public final static String CY_APP_2017 = "96"; // 2017抽奖，所属APP

		public final static String CYCLE_TRANS = "104"; // 透传类型限制周期
		
		public final static String COLLECT_CYCLE = "105"; // 集福开奖-限制周期
		public final static String COLLECT_INTFID = "106"; // 集福开奖-开奖id
		public final static String COLLECT_LABEL = "107"; // 集福开奖-回退标签
		
		
		public final static String CJ_PAY_TYPE_DH = "108"; // 必中抽奖，扣除类型
		public final static String CJ_MONEY_DH = "109"; 
		
		public final static String SHARE_NEW_USER_CYCLE = "110";  //分享新用户类型-限制周期
		public final static String OLD_USER_KAFKA_CYCLE = "111";  //老用户领取物品-限制周期
		
		public final static String CY_CYCLE_RED_ENVELOPE = "112"; // 直播红包雨抽奖, 限制周期
		public final static String CJ_PAY_TYPE_RED_ENVELOPE = "113"; // 直播红包雨，扣除类型
		public final static String CJ_MONEY_RED_ENVELOPE = "114"; // 直播红包雨，扣除机会
		public final static String CY_APP_RED_ENVELOPE = "115"; // 直播红包雨，所属APP
				
		public final static String REDUCE_COUPON_KAFKA_CYCLE = "116"; // 扣券领取多物品, 限制周期
		public final static String REDUCE_COUPON_KAFKA_TYPE = "117"; // 扣券领取多物品，扣除类型
		public final static String REDUCE_COUPON_KAFKA_MONEY = "118"; // 扣券领取多物品，扣除机会
		public final static String REDUCE_COUPON_KAFKA_APP = "119"; // 扣券领取多物品，所属APP
		
		public final static String DELIVERY_ACTIVITY_CYCLE = "121";// 交付夺宝众筹，限制周期
		
		public final static String PRE_INSTALL_CYCLE = "122";// 4G+，限制周期
		
		public final static String UNSIGN_IN_LIMIT_RULE = "123"; //非连续签到，限制规则
		
		public final static String MANY_OLD_USER_KAFKA_CYCLE = "124"; //多老用户领取奖品-限制周期
		
		public final static String CARD_PASSWORD_LIST_CYCLE = "125"; //卡密兑换物品-限制周期
		
		public final static String INVITE_USER_WON_PRIZE_CYCLE = "126"; //卡密兑换物品-限制周期
		
		
		public final static String SECRET_CYCLE_2017 = "127"; // 口令夺宝抽奖 限制周期
		public final static String SECRET_PAY_TYPE_2017 = "128"; // 口令夺宝抽奖，扣除类型
		public final static String SECRET_MONEY_2017 = "129"; // 口令夺宝抽奖，扣除机会
		public final static String SECRET_APP_2017 = "130"; // 口令夺宝抽奖，所属APP
		public final static String  DISCRETE_SIGN_PERIOD = "131"; // 非连续签到周期；
	}

	public final static class Cycle {
		public final static String DAY = "1";
		public final static String MONTH = "2"; // 月
		public final static String ACT = "3";
		public final static String NONE = "4"; // 不限制
		public final static String ACT_ALL = "5"; // 整个活动
	}

	/**
	 * 货币类型
	 * 
	 * @author xujiamin
	 *
	 */
	public final static class PayType {
		/*
		 * public static final String SYSTEM_ACTIVITY = "1"; //营销平台 public
		 * static final String SYSTEM_ACCOUNT = "2"; //账户系统 public static final
		 * String NONE = "3"; //什么都不扣，直接抽奖
		 */

		public static final String SYSTEM_ACTIVITY = "5"; // 营销平台
		public static final String SYSTEM_ACCOUNT = "4"; // 账户系统
		public static final String NONE = "2"; // 什么都不扣，直接抽奖
		public static final String SYSTEM_AUTH 	= "6"; //鉴权系统
	}

	public final static class KeyName {
		public final static String MESSAGE_COUPON = "34";//发送短信卡密
		public final static String WH_MIGU_COIN = "41"; // 咪咕文化-咪咕币充值
		public final static String WH_MIGU_FLOW = "42"; // 咪咕文化-流量充值		
	}

	/**
	 * 货币类型
	 * 
	 * @author xujiamin
	 *
	 */
	/*
	 * public final static class PayType { public static final String
	 * SYSTEM_ACTIVITY = "5"; //营销平台 public static final String SYSTEM_ACCOUNT =
	 * "4"; //账户系统 public static final String NONE = "2"; //什么都不扣，直接抽奖 }
	 */

	/**
	 * 限制数量
	 * 
	 * @author zhangwei
	 *
	 */
	public final static class LimitNumber {
		public final static String OFF = "1"; // 关
		public final static String ON = "2"; // 开
	}

	public interface PreRegisterCode {

		public final static int SUCCESS = 0; // 返回成功
		public final static int FAIL = -1; // 返回失败

		public final static int PARAM_ERROR = 1; // 参数错误
	}

	public final static class IntfOpType {
		public final static int HTTP = 1;// http请求
		public final static int KAFKA = 2;// kafka消息
		public final static int DELIVERY = 3;// 交付系统交付请求
	}

	public final static class CouponResultCode {
		public final static int SUC = 0;
	}

	public final static class PaymentVoParamKey {

		public final static String MOBILE = "MOBILE";// 手机号
		public final static String BODY = "BODY";
		public final static String TOKEN = "TOKEN"; // 用户一级登录信息
		public final static String BUYEREMAIL = "BUYEREMAIL"; // 支付宝账号
		public final static String DELIVERYID = "DELIVERYID"; // 订单号
		public final static String USERWINNUM = "USERWINNUM"; // 用户中奖号
		public final static String ORDERID = "ORDERID"; // 订单号
		// public final static String CHANNEL = "CHANNEL"; //渠道
		public final static String SCORE = "SCORE";

		public final static Set<String> getKeys() {
			Set<String> sets = new HashSet<String>();
			// sets.add(MOBILE);
			sets.add(BODY);
			// sets.add(TOKEN);
			// sets.add(BUYEREMAIL);
			// sets.add(DELIVERYID);
			// sets.add(USERWINNUM);
			// sets.add(ORDERID);
			return sets;
		}
	}

	public final static class UserLabelType {
		public final static int userid = 1;//
		public final static int mobile = 2;//
		public final static int imei = 3;//
		public final static int idfa = 4;//
		public final static int dsn = 5;//

	}

	public final static class IntfLabelLimitType {
		public final static int MUST_IN = 0;// 仅限： 必须包含次标签
		public final static int MUST_NOT_IN = 1;// 禁止：禁止有此标签
	}

	// 是否获得物品
	public final static class HasWare {
		public final static int yes = 1;
		public final static int no = 2;
	}

	public interface VoteParam {

		public final static String SPLIT_UNDERLINE = "_";
		public final static String SPLIT_COMMA = ",";
		public final static int NO_LIMIT = 1;
		public final static int ONCE_A_DAY = 2;
		public final static int ONCE_AN_ACTIVITY = 3;
		public final static int ONCE_A_MONTH = 4;
		public final static int IS_NOT_PUBLISH = 1; // 投票未开始
		public final static int IS_END = 3; // 投票已结束
		public final static String VOTE = "投票";

		public final static int SCORE = 0; // 元气值
		public final static int BEAN = 1; // 咪豆
		public final static int DIAMOND = 2; // 咪钻
		public final static int JIAOPIAN = 3; // 咪咕影院胶片

		public final static int BENIFIT = 1; // 利润
		public final static int PROBABILITY = 2; // 概率
	}

	public interface VoteResponseMsg {

		public final static String SUCCESS = "请求成功";
		public final static String PARAM_ERROR = "参数错误";
		public final static String ALREADY_VOTE = "您已投过票";
		public final static String VOTE_NOT_START = "投票尚未开始";
		public final static String VOTE_IS_END = "活动已经结束";
		public final static String VOTE_NOT_EXIST = "投票活动不存在";
		public final static String SCORE_NOT_ENOUGH = "元气值不足";
		public final static String BEAN_NOT_ENOUGH = "咪豆不足";
		public final static String DIAMOND_NOT_ENOUGH = "咪钻不足";
		public final static String COUNT_LIMIT = "次数限制到了";
		public final static String ALREADY_IN_ACTICITY = "你已参加过该活动";
		public final static String IS_NOT_PUBLISH = "投票活动还未发布";
		public final static String IS_END = "投票活动已经结束";
		public final static String DUPLICATE_VOTEITEM = "投票选项重复";
		public final static String ILLEGAL_NUMBER = "非法数字";
		public final static String PAYMENT_ERROR = "支付错误";
		public final static String OUT_OF_RANGE = "投票项已超过总数";
	}

	/**
	 * 交付物品
	 * 
	 * @author zhangwei
	 *
	 */
	public static interface Delivery {
		public final static String INTF_ID 	= "INTF_ID"; // 交付接口ID
		public final static String MOBILE 	= "MOBILE"; // 手机号
		public final static String MOBILELIST = "MOBILELIST"; // 手机号
		public final static String paymentAccount = "paymentAccount"; // 手机号
		public final static String paymentCode = "paymentCode"; // 手机号
		public final static String paymentId = "paymentId"; // 手机号
		public final static String token = "token"; // 集团一级登录信息
		// public final static String sellerId = "sellerId"; // 卖家支付宝账号
		public final static String orderId = "orderId"; // 订单号
		public final static String buyerEmail = "buyerEmail"; // 买家支付宝账号
		public final static String acctNo = "acctNo"; // 浦发卡号
		
		public final static String sessionId = "sessionId";  //add by xjm 新增场次Id（观影会）
	}

	public static interface Role {
		public final static int VIP = 0; // 会员
		public final static int NORMAL = 1; // 普通用户
		public final static int NONE = 2; // 不限制

		// public final static int HBO = 3; //HBO增值包用户
		// public final static int TVB = 4; //TVB增值包
	}

	public static final class VoteItemClaimStatus {
		public final static int INIT = 1;
		public final static int FAIL = 2;
		public final static int SUC = 3;
	}

	public static final class VoteVersion {
		public final static int VOTE = 1; // 原先的投票方法
		public final static int VOTEV2 = 2; // 现在的投票方法
	}

	public static interface LogType {
		public final static int SIGN = 1; // 签到日志
		public final static int WARE = 2; // 用户获取物品明细日志
		public final static int DELIVERY_RESPONSE = 3; // 交付系统回调日志
	}

	public static class FixedLabels {
		public final static String GUANGDONG_MOBILE_OLYMIPIC_LABEL = "9000003";
		public final static String TEST_USER_LABEL = "1000001";
	}

	/**
	 * 卡平台回调接口参数
	 *
	 */
	public static class CardPlatformParam {
		public final static String SUCCESS = "SUCCESS";
		public final static String FAIL = "FAILED";
		public final static String ERR_UNKONWN = "ERR_UNKONWN";
		public final static String ACCEPTED = "ACCEPTED";
	}

	public static class TestItemRelaType {
		public final static int RIGHT = 1; // 正确答案
		public final static int FIXED = 2; // 强制绑定答案
	}

	/**
	 * 营销活动物品限制关系周期类型
	 *
	 */
	public static class ActWareLimitPeriodType {
		public final static int MINUTE = 0; // 分
		public final static int DAY = 1; // 天
		public final static int MONTH = 2; // 月
		public final static int ACTIVITY_PERIOD = 3; // 活动期间
		public final static int INTF = 4; // 接口
		public final static int INTF_PERIOD = 5; // 接口开放时间
		public final static int INTERVAL_PERIOD = 10; // 间隔时长
		public final static int HOURS = 11; // 小时
	}

	public static class NeedRollBackParamValue {
		public final static Integer YES = 1;
		public final static Integer NO = 0;

	}

	public static class DeliverType {
		public final static int MAN = 1; // 人工交付
		public final static int DELAY = 2; // 延期交付
		public final static int NOW = 3; // 实时交付
		public final static int VIP = 4; // VIP交付
	}

	public static class PayAccountLimit {
		public final static String NO = "0";
		public final static String ALI = "1"; // 支付宝
		public final static String PUFA = "2"; // 浦发

	}

	public static class InviteStatus {

		public final static int NOT_LOGIN = 0; // 未登陆
		public final static int LOGIN = 1; // 已登陆
	}

	public static final class SubBeanResponse {

		public final static String SUCCESS = "200"; // 成功
		public final static String FAIL = "100"; // 失败
	}

	public static class LotteryMode {
		public final static int PROFIT = 1; // 利润
		public final static int PROBABILITY = 2; // 概率
		public final static int NONE = 3; // 不开奖
	}

	public static class Restricted { // 限制次数是否到了
		public final static int NO = 0;
		public final static int YES = 1;
	}

	public static class DoubleLimit {
		public final static int OPEN = 1; // 打开
		public final static int CLOSE = 2; // 关闭
	}

	public static class Encrypted {
		public final static int OPEN = 1; // 打开
		public final static int CLOSE = 2; // 关闭
	}

	public static interface ExpireType {
		public final static int NO_EXPIRE = 0; // 无有效期
		public final static int MINUTE = 1; // 分钟
		public final static int DAY = 2; // 天
		public final static int MONTH = 3; // 月
		public final static int YEAR = 4; // 年
		public final static int END_OF_DAY = 21; // 日终
		public final static int END_OF_MONTH = 22; // 月末
		public final static int END_OF_YEAR = 23; // 年末
		public final static int DIRECT = 100; // 指定日期
	}

	public static interface BudgetOrFinal {
		public final static int BUDGET = 1; // 无有效期
		public final static int FINAL = 2; // 分钟
	}

	public static interface IntfLimitType {
		public final static int DAY = 1;
		public final static int MONTH = 2;
		public final static int ACT = 3;
		public final static int NONE = 0;
		public final static int ACT_ALL = 5;
	}

	public static interface IsGetAll {
		public final static String YES = "1";
		public final static String NO = "2";
	}

	public static interface QcatType {
		public final static int RAND = 1;
		public final static int STATIC = 2;
	}

	public static interface SystemClose {
		public final static String YES = "1";
		public final static String NO = "2";
	}

	public static interface Global {
		public final static String CLOSE_SYSTEM = "CLOSE_SYSTEM";
	}

	public static interface TimeType {
		public final static String HOURS = "1";
		public final static String DAY = "2";
	}

	public static interface isLogin {
		public final static int YES = 1;
		public final static int NO = 2;
	}

	public static interface Effc {
		public final static String DAY = "1"; // 每天
		public final static String MONTH = "2"; // 每月
		public final static String NONE = "3"; // 活动期间
	}

	public static interface ActType {
		public final static String DEF = "1";
		public final static String TP = "2"; // 通用投票
	}

	public static interface LimitAns {
		public final static Integer YES = 1;
		public final static Integer NO = 2;
	}

	public static class Channel {
		public static Set<String> values = new HashSet<String>();
		static {
			values.add("10290001004"); // H5渠道
			values.add("1003000100010001"); // 客户端渠道
		}
	}
	
	
	public static class Mno {
		public static Set<String> values = new HashSet<String>();
		static {
			values.add("10086");
			values.add("10000");
			values.add("10010");
		}
	}
	

	/**
	 * 是否验证新用户
	 * 
	 * @author admin
	 *
	 */
	public static interface CkNewUser {
		public final static String yes = "1"; // 验证
		public final static String no = "2"; // 不验证
	}

	public final static class RequestExt {
		public final static String INTFID = "INTFID";
		public final static String ID = "ID";
		public final static String TYPE = "TYPE";
	}

	public final static class ExtType {
		public final static String WARE = "WARE";
		public final static String HAND = "HAND";
	}

	public static interface HandDeliveryResult {
		public final static String WAIT = "0"; // 待交付
		public final static String SUCCESS = "1"; // 交付成功
		public final static String FAIL = "2"; // 交付失败
		public final static String RESNEDING = "100";// 重发中
	}

	public static interface SessionKey {
		public final static String INTF_CONFIG = "INTF_CONFIG";
	}

	public static interface ItemVoteParam {
		public final static String SINGLE_ITEM = "10001";// 单次投票项的最多和最少票数
	}

	/*
	 * public static class GetResourceId{ private static Map<String, String>
	 * datas = new HashMap<String, String>();;
	 * 
	 * static { datas.put("1001", "2028600291"); //HBO datas.put("1002",
	 * "2028600282"); //TVB }
	 * 
	 * public static String get(String role){ return datas.get(role); }
	 * 
	 * }
	 */

	public static interface Checklogic {
		public final static int IN = 1; // 仅限
		public final static int OUT = 2; // 禁止
	}

	public static interface Sysid {
		public final static int AUTH = 1; // 用户中心鉴权组件
		public final static int ACTIVITY = 2; // 营销平台
		public final static int BIGDATA = 3; // 大数据中心
	}

	// 咪咕文化校园活动赠送流量及咪咕币的Code
	public static final class MiguCode {
		public final static int SUCCESS = 200; // 赠送成功
		public final static int CODE_201 = 201; // 充值中
		public final static int CODE_300 = 300; // 已参与赠送
		public final static int CODE_301 = 301; // 余额不足
		public final static int CODE_302 = 302; // 赠送失败
		public final static int CODE_9000 = 9000; // 系统内部错误
		public final static int CODE_9111 = 9111; // token无效
		public final static int CODE_9222 = 9222; // 参与校验失败
	}
	
	//投票的交付方式
	public static interface VoteDelivery {
		public final static String ACTIVITY = "1"; // 营销活动
	}
	
	/**
	 * 投票的参数数据表
	 * @author xjm
	 *
	 */
	public static final class VoteInfoParamKey {
		public final static String SINGLE_ITEM = "10001";// 单次投票项的最多和最少票数
		public final static String CLAIM_TYPE="10002";//投票赔付类型	
		public final static String INTF_ID="10003";//接口ID
		public final static String DELIVERY_TYPE="10004";//交付方式：营销活动 1
		public final static String CLAIM_FAIL_TIME="10005";//赔付资源失效时间
		public final static String CLAIM_DESC="10006";//投票赔付描述
	}
	
	
	public static interface LabelType{
		public final static Integer USER_ID = 1;
		public final static Integer MOBILE  = 2;
	}
	public static final class ClaimType {
        public final static String FIXED_ODDS = "2";//固定赔率
        public final static String CHANCE = "3";// 概率
    }
	
	
	public static final class MsgHasCode{
		public final static int no = 0;
		public final static int yes = 1;
		
	}
	
	public static final class OldUserWareType{ 
		public final static int WAIT = 1;  //未领取
		public final static int RECEIVE = 2;  //已领取
	}
	
	/**
	 * 夺宝众筹活动开奖状态
	 * @author xjm
	 */ 
	public static final class LotteryConfigStatus{
		public final static Integer INIT 	= 1;
		public final static Integer SUCCESS = 2;
		public final static Integer FAIL 	= 3;
	} 
	
	/**
	 * 电影卡卡密充值接口,激活方式
	 * @author xjm
	 */ 
	public static final class ActivateProduct{
		public final static String MOVIE 	= "1"; //咪咕影院
		public final static String HTML    = "2"; //H5
	} 
	
	/**
	 * 电影卡卡密充值接口,激活方式
	 * @author xjm
	 */ 
	public static final class IsMainWare{
		public final static Integer mainWare 	  = 1; //主交付物
		public final static Integer notMainWare   = 2; //非主交付物
	} 
	
	/**
	 * es的表名
	 * @author xjm
	 */ 
	public static final class EsTableName{
		public final static String  wareUserDetail	= "wareUserDetail"; //用户获取物品明细表		
	} 
	
	/**
	 * es的index
	 * @author xjm
	 */ 
	public static final class EsIndexName{
		public final static String  promWare = "promware"; //用户获取物品明细表		
	} 
	public static final class DiscreteSignPeriod{
		public final static String  ONE_WEEK = "1"; 
		public final static String  ONE_MONTH = "2";
	}
}
