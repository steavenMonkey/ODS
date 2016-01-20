package com.manyouyou.ordersystem.utils;

public class StringUtil {
	
	/**
	 * 判断字符串是否为blank or null
	 * @param str
	 * @return
	 */
	public static boolean isNullOrBlank(String str){
		if(str != null && str.trim().length() > 0){
			return true;
		}else{
			return false;
		}
	}
	
	
}
