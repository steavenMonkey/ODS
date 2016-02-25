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
 * Created on 2015年6月17日
 *******************************************************************************/


package org.training.example.fastjson;

import java.io.Serializable;
import java.util.Map;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public class Teacher implements Serializable{
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 6231002957028737843L;
	private String name;
	private int age;
	private Map<String,String> nums;
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
	public int getAge() {
		return age;
	}
	/**
	 * @param age The age to set.
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return Returns the nums.
	 */
	public Map<String, String> getNums() {
		return nums;
	}
	/**
	 * @param nums The nums to set.
	 */
	public void setNums(Map<String, String> nums) {
		this.nums = nums;
	}
	
	
}

/*
 * 修改历史
 * $Log$ 
 */