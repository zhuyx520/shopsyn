package com.qiyue.shopsyn.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChinaCharUtil {
	
	public static String getChinaChar(String str) {
        StringBuffer res = new StringBuffer();
        String exp="^[\u4E00-\u9FA5|\\！|\\,|\\。|\\（|\\）|\\《|\\》|\\“|\\”|\\？|\\，|\\。|\\：|\\；|\\【|\\】|1-9]$";
        Pattern pattern=Pattern.compile(exp);
        for (int i = 0; i < str.length(); i++) {// 遍历字符串每一个字符
            char c = str.charAt(i);
            Matcher matcher=pattern.matcher(c + "");
            if(matcher.matches()) {
            	res.append(c);
            }
        }
        return res.toString();
    }
	
	public static String getPrice(String str) {
		if(str.contains("\n")){
			str = str.replaceAll("\n", "");
		}
		if(str.indexOf("万元") != -1) {
        	float f = Float.valueOf(str.substring(0, str.length()-2));
        	String price =  String.valueOf(f * 10000);
        	return price;
        }else if(str.indexOf("万") != -1) {
        	float f = Float.valueOf(str.substring(0, str.length()-1));
        	String price =  String.valueOf(f * 10000);
        	return price;
        }else if(str.indexOf("无") != -1){
        	return "0";
        }else {
        	return str.substring(0, str.length()-1);
        }
    }

	public static String getDescription(String desc) {
		int tmp = desc.indexOf(",房源编号：662933266487296");
		if(tmp != -1) {
			String result = desc.substring(0, tmp); 
			return result;
		}
		int tmp1 = desc.indexOf("联系我时");
		if(tmp1 != -1) {
			String result = desc.substring(0, tmp1); 
			return result;
		}
		return desc;
    }
}
