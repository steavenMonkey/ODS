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
 * Created on 2015年5月17日
 *******************************************************************************/


package org.training.example.integration;

import java.io.IOException;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public class TestServer {
	public static void main(String[] args) {
		IRemoteServer server;
		try {
			server = new RemoteServermpl("127.0.0.1", 18081);
			server.bind(StudentServiceImpl.class.getName(), new StudentServiceImpl());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

/*
 * 修改历史
 * $Log$ 
 */