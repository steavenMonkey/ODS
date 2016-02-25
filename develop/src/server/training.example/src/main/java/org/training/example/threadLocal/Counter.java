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

public class Counter {
	
	private CounterContext context = CounterContext.getInstance();
	public void show(){
		String name = context.get();
		System.out.println(name);
	}
}

/*
 * 修改历史
 * $Log$ 
 */