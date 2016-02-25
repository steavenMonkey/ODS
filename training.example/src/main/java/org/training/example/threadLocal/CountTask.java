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

public class CountTask extends Thread{
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	private String name;
	public CountTask(String name){
		super();
		this.name = name;
	}
	private CounterContext context = CounterContext.getInstance();
	@Override
	public void run() {
		context.set(name);
		System.out.println("set name to threadLocal");
		Counter counter = new Counter();
		counter.show();
	}
}

/*
 * 修改历史
 * $Log$ 
 */