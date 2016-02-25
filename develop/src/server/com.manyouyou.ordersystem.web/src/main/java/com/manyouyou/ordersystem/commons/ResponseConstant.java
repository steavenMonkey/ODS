package com.manyouyou.ordersystem.commons;

import java.io.File;

public class ResponseConstant {
	
	
	public static final String PATH_VIEW_ORDER = "view/order";
	public static final String PATH_VIEW_USER = "view/user";
	
	public static final String PATH_SEPARATOR = File.separator;
	
	public static final String RSP_PAGE_LOGIN = "index";
	public static final String RSP_PAGE_REGIST = PATH_VIEW_USER + PATH_SEPARATOR + "registUser";
	
	public static final String RSP_PAGE_ORDER_MYORDER = PATH_VIEW_ORDER + PATH_SEPARATOR + "myOrder";
	
	
	public static final String RSP_ATTR_LOGIN_ERROR = "loginErrStr";
	public static final String RSP_ATTR_REGIST_ERROR = "registErrStr";
}
