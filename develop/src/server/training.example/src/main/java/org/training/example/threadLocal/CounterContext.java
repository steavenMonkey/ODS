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
 * Created on 2015年7月3日
 *******************************************************************************/


package org.training.example.threadLocal;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public class CounterContext {
	private ThreadLocal<String> varThreadLocal = new ThreadLocal<String>();
	private static CounterContext context = new CounterContext();
	
	private CounterContext(){
		
	}
	
	public static CounterContext getInstance(){
		return context;
	}
	
	public void set(String value){
		varThreadLocal.set(value);
	}
	
	public String get(){
		return varThreadLocal.get();
	}
	
	public void remove(){
		varThreadLocal.remove();
	}
}

/*
 * 修改历史
 * $Log$ 
 */