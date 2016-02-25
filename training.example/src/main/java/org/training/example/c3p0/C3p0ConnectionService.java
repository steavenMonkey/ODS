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

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.DataSources;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public class C3p0ConnectionService {
	private static DataSource ds;
	
	static{
		init();
	}
	
	private static void init(){
		Properties properties = new Properties();
		InputStream in = C3p0ConnectionService.class.getResourceAsStream("c3p0.properties");
		try {
			properties.load(in);
			
			Class.forName(properties.getProperty("driverClass"));
			
			Properties jdbcpropes = new Properties();
			Properties c3propes = new Properties();
			for (Object key : properties.keySet()) {
				String skey = (String) key;
				if (skey.startsWith("c3p0.")) {
					c3propes.put(skey, properties.getProperty(skey));
				} else {
					jdbcpropes.put(skey, properties.getProperty(skey));
				}
			}
			
				// 建立连接池
				DataSource unPooled = DataSources.unpooledDataSource(properties.getProperty("jdbcUrl"), jdbcpropes);
				ds = DataSources.pooledDataSource(unPooled, c3propes);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static synchronized Connection getConnection(){
		Connection conn = null;
		try {
			conn = ds.getConnection();
			conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}

/*
 * 修改历史
 * $Log$ 
 */