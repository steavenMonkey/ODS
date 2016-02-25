package com.manyouyou.ordersystem.commons;

public class SQLConstant {
	
	
	public static final String HQL_QUERY_USER_BY_NAME = "from UserInfoModel where name=?";
	
	public static final String SQL_QUERY_USER_BY_NAME = "select userid,username,password,phonenum from userinfo where username=?";
}
