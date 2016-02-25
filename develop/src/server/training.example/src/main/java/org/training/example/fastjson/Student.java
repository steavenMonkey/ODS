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
 * Created on 2015年6月2日
 *******************************************************************************/


package org.training.example.fastjson;

import java.io.Serializable;
import java.util.Map;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public class Student implements Serializable{
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -3811498230559331117L;
	private String name;
	private Map<String,String> extensions;
	private Object context;
	private Object teacher;
	
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
	 * @return Returns the extensions.
	 */
	public Map<String, String> getExtensions() {
		return extensions;
	}
	/**
	 * @param extensions The extensions to set.
	 */
	public void setExtensions(Map<String, String> extensions) {
		this.extensions = extensions;
	}
	/**
	 * @return Returns the context.
	 */
	public Object getContext() {
		return context;
	}
	/**
	 * @param context The context to set.
	 */
	public void setContext(Object context) {
		this.context = context;
	}
	/**
	 * @return Returns the teacher.
	 */
	public Object getTeacher() {
		return teacher;
	}
	/**
	 * @param teacher The teacher to set.
	 */
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
}

/*
 * 修改历史
 * $Log$ 
 */