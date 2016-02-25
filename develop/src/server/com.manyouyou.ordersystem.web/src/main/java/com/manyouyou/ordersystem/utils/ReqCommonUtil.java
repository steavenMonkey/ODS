package com.manyouyou.ordersystem.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class ReqCommonUtil {
	
	public static HttpServletRequest getRequest(){
		ServletRequestAttributes  attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return attr.getRequest();
	}
	
	public static HttpSession getSession(){
		HttpSession session = null;
		session = getRequest().getSession();

		return session;
	}
}
