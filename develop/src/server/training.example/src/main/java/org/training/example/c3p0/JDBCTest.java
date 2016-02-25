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
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public class JDBCTest {
	public static void main(String[] args) {
		/*#jdbc基本信息
c3p0.driverClass=com.mysql.jdbc.Driver
c3p0.user=root
c3p0.jdbcUrl=jdbc:mysql://192.168.11.25:3306/bpm1335
c3p0.password=ROOT
		 * */
		
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
//			Class.forName("com.mysql.jdbc.Driver");
//			String url = "jdbc:mysql://192.168.11.25:3306/bpm1335";
			String url = "jdbc:db2://192.168.1.118:50000/weixin";
			String usr = "weixin";
			String pwd = "123@abc";
			Connection conn = DriverManager.getConnection(url, usr, pwd);
			System.out.println(conn);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

/*
 * 修改历史
 * $Log$ 
 */