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
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public class StudentServiceClient {
	public static void main(String[] args) {
		try {
			IStudentService service = (IStudentService) Naming.lookup("rmi://localhost:18081/studentService");
			List<Student> students = service.getStudentList();
			for (Student student : students) {
				System.out.println(student.getName() + " " + student .getAge());
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

/*
 * 修改历史
 * $Log$ 
 */