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
 * Created on 2015年5月13日
 *******************************************************************************/


package org.training.example.integration;

import java.io.Serializable;

import org.training.example.rmi.Student;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public class StudentServiceImpl implements IStudentService{

	/* (non-Javadoc)
	 * @see org.training.example.integration.IStudentService#getStudent()
	 */
	@Override
	public Student getStudent() {
		Student s = new Student();
		s.setAge(1+"");
		s.setName("student1");
		return s;
	}

}

/*
 * 修改历史
 * $Log$ 
 */