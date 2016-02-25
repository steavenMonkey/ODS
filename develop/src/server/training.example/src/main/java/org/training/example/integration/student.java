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

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public class student implements Serializable{

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 2538955852153809375L;
	
	private String name;
	private String age;
	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return Returns the age.
	 */
	public String getAge() {
		return age;
	}
	/**
	 * @param age The age to set.
	 */
	public void setAge(String age) {
		this.age = age;
	}
	
	
}

/*
 * 修改历史
 * $Log$ 
 */