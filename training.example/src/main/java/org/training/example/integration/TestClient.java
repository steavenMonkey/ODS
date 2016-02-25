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

import org.training.example.rmi.Student;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public class TestClient {
	public static void main(String[] args) {
		IRemoteClient client;
		try {
			client = new RemoteClientImpl("127.0.0.1", 18081);
			IStudentService service = client.lookup(StudentServiceImpl.class.getName());
			Student stu = service.getStudent();
			System.out.println(stu.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

/*
 * 修改历史
 * $Log$ 
 */