/*******************************************************************************
 * $Header$
 * $Revision$
 * $Date$
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2012 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2015年5月9日
 *******************************************************************************/


package org.training.example.c3p0;

import java.sql.Connection;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public class Test {
	public static void main(String[] args) throws Throwable {
		
//		Connection conn = null;
//		Class.forName("com.mysql.jdbc.Driver");
//		String DBURL = "jdbc:mysql://192.168.11.25:3306/bpm1335";
//		String DBUSER = "root";
//		String DBPWD = "ROOT";
//		conn = DriverManager.getConnection(DBURL,DBUSER,DBPWD);
//		System.out.println(conn);
		
		Connection conn = C3p0ConnectionService.getConnection();
		System.out.println(conn);
	}
}

/*
 * 修改历史
 * $Log$ 
 */