package com.manyouyou.ordersystem.utils;

import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;

public class StringUtil extends StringUtils{
	
	
	/**
	 * 采用Base64算法对字符串加密
	 * 返回加密后的字符串
	 * @param str 需要加密的字符串
	 * @return
	 */
	public static String encode(String str){
		byte[] b = null;
		String ret = null;
		if(!isEmpty(str)){
			
			b = str.getBytes();
			ret = Base64Utils.encodeToString(b);
		}else{
			throw new RuntimeException("the source str cannot be null or blank");
		}
		
		return ret;
	} 
	
	/**
	 * 采用Base64算法对字符串解密
	 * 返回解密后的字符串
	 * @param str 待解密的字符串
	 * @return
	 */
	public static String decode(String str){
		byte[] b = null;
		String ret = null;
		if(!isEmpty(str)){
			b = Base64Utils.decodeFromString(str);
			ret = new String(b);
		}else{
			throw new RuntimeException("the source str cannot be null or blank");
		}
		return ret;
	}
	
	
}
