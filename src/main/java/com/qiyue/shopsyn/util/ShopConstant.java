package com.qiyue.shopsyn.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.qiyue.shopsyn.util.StringUtil;

@Component
public class ShopConstant {
	
	private final static Map<Integer,String[]> shType = new HashMap<Integer,String[]>();
	private final static Map<Integer,String[]> shPartType = new HashMap<Integer,String[]>();
	
	static{
		shType.put(ShopConstant.T01, new String[]{"美食","餐饮","外卖","菜"});
		shType.put(ShopConstant.T02, new String[]{"娱乐","休闲","电影"});	
		shType.put(ShopConstant.T03, new String[]{"美容","美发"});
		shType.put(ShopConstant.T04, new String[]{"旅游","宾馆"});
		shType.put(ShopConstant.T05, new String[]{"百货","超市"});
		shType.put(ShopConstant.T06, new String[]{"教育","培训"});
		shType.put(ShopConstant.T07, new String[]{"汽","车","配件","汽配"});
		shType.put(ShopConstant.T08, new String[]{"综","合"});
		shType.put(ShopConstant.T09, new String[]{""});
		shType.put(ShopConstant.T10, new String[]{""});
		shType.put(ShopConstant.T11, new String[]{""});
		shType.put(ShopConstant.T12, new String[]{"网吧","游戏","电玩"});
		shType.put(ShopConstant.T13, new String[]{"批发","零售"});
		shType.put(ShopConstant.T14, new String[]{"公司","工厂"});
		shType.put(ShopConstant.T15, new String[]{"医","药","保健"});
		shType.put(ShopConstant.T16, new String[]{"中介","服务"});
		shType.put(ShopConstant.T17, new String[]{"印刷","影像"});
		shType.put(ShopConstant.T18, new String[]{"文","教育"});
		shType.put(ShopConstant.T19, new String[]{"洗","清洁"});
		shType.put(ShopConstant.T20, new String[]{"宠物","爱好"});
		shType.put(ShopConstant.T21, new String[]{"其","类"});
		
		shPartType.put(ShopConstant.P01, new String[]{"客梯"});
		shPartType.put(ShopConstant.P02, new String[]{"货梯"});	
		shPartType.put(ShopConstant.P03, new String[]{"中央空调"});
		shPartType.put(ShopConstant.P04, new String[]{"停车位"});
		shPartType.put(ShopConstant.P05, new String[]{"天然气"});
		shPartType.put(ShopConstant.P06, new String[]{"网络"});
		shPartType.put(ShopConstant.P07, new String[]{"暖气"});
		shPartType.put(ShopConstant.P08, new String[]{"扶梯"});
		shPartType.put(ShopConstant.P09, new String[]{"上水"});
		shPartType.put(ShopConstant.P10, new String[]{"下水"});
		shPartType.put(ShopConstant.P11, new String[]{"排烟"});
		shPartType.put(ShopConstant.P12, new String[]{"排污"});
		shPartType.put(ShopConstant.P13, new String[]{"管煤"});
		shPartType.put(ShopConstant.P14, new String[]{"380V"});
		shPartType.put(ShopConstant.P15, new String[]{"可明火"});
		shPartType.put(ShopConstant.P16, new String[]{"外摆区"});
	}

	public final static int T01 = 1; // 美食餐饮
	public final static int T02 = 2; // 娱乐休闲
	public final static int T03 = 3; // 美容美发
	public final static int T04 = 4; // 旅游宾馆
	public final static int T05 = 5; // 百货超市
	public final static int T06 = 6; // 教育培训
	public final static int T07 = 7; // 汽车配件
	public final static int T08 = 8; // 综合转让
	public final static int T09 = 9; // 
	public final static int T10 = 10; // 
	public final static int T11 = 11; // 
	public final static int T12 = 12; // 网吧游戏
	public final static int T13 = 13; // 批发零售
	public final static int T14 = 14; // 公司工厂
	public final static int T15 = 15; // 医药保健
	public final static int T16 = 16; // 中介服务
	public final static int T17 = 17; // 印刷影像
	public final static int T18 = 18; // 文化教育
	public final static int T19 = 19; // 洗衣清洁
	public final static int T20 = 20; // 宠物爱好
	public final static int T21 = 21; // 其它类别
	
	public final static int P01	= 1; // 客梯
	public final static int P02 = 2; //	货梯
	public final static int P03 = 3; //	中央空调
	public final static int P04 = 4; //	停车位
	public final static int P05 = 5; //	天然气
	public final static int P06	= 6; // 网络
	public final static int P07	= 7; // 暖气
	public final static int P08 = 8; //	扶梯
	public final static int P09 = 9; //	上水
	public final static int P10	= 10; // 下水
	public final static int P11	= 11; // 排烟
	public final static int P12	= 12; // 排污
	public final static int P13	= 13; // 管煤
	public final static int P14	= 14; // 380V
	public final static int P15	= 15; // 可明火
	public final static int P16	= 16; // 外摆区
	
	public final static String[] getMessage(Integer code){
		String[] msg = shType.get(code);
		if(StringUtil.isBlank(msg)){
			msg = new String[] {""};
		}
		return msg;
	}
	
	// 判断该标题对应的类别
	public final static int getShType(String message) {
		for (int i = 1; i < 21 ; i++) {
			String[] onType = shType.get(i);
			for(String str : onType) {
				int cnt = message.indexOf(str);
				if(cnt > 0) {
					return i;
				}
			}
		}
		return 21;
	}
	
	// 判断该标题对应的类别
	public final static int getShPartType(String message) {
		for (int i = 1; i < 16 ; i++) {
			String[] onType = shPartType.get(i);
			for(String str : onType) {
				int cnt = message.indexOf(str);
				if(cnt >= 0) {
					return i;
				}
			}
		}
		return 16;
	}
	
	// 判断该配套对应的类别S
	public final static String getShPartTypeS(String message) {
		String[] parts = message.split(",");
		String result = message;
		for(String str : parts) {
			String tmp = result;
			int type = getShPartType(str);
			result = tmp.replaceFirst(str, type+"");
		}
		return result;
	}

	
	public static void sleep(long micro_second) {
		try {
			Thread.sleep(micro_second);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
