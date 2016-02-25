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

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public class StudentServiceImpl extends UnicastRemoteObject implements IStudentService{

	/**
	 * @throws RemoteException
	 */
	public StudentServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 2459610056166867501L;

	/* (non-Javadoc)
	 * @see org.training.example.rmi.StudentService#getStudentList()
	 */
	@Override
	public List<Student> getStudentList() throws RemoteException {
		List<Student> list = new ArrayList<Student>();
		
		for(int i=0;i<2;i++){
			Student s = new Student();
			s.setAge("age"+i);
			s.setName("name"+i);
			list.add(s);
		}
		
		return list;
	}

}

/*
 * 修改历史
 * $Log$ 
 */