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
 * Created on 2015年5月10日
 *******************************************************************************/


package org.training.example.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public class StudentServiceServer {
	public static void main(String[] args) {
		try {
			IStudentService service = new StudentServiceImpl();
			LocateRegistry.createRegistry(18081);
			Naming.rebind("rmi://localhost:18081/studentService", service);
			
		} catch (MalformedURLException | RemoteException e) {
			e.printStackTrace();
		}
	}
}

/*
 * 修改历史
 * $Log$ 
 */