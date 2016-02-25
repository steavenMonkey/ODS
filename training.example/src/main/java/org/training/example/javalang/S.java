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
 * Created on 2015年6月25日
 *******************************************************************************/


package org.training.example.javalang;

import java.util.concurrent.CountDownLatch;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public class S implements Runnable{
	private CountDownLatch downLatch;

	/**
	 * @return Returns the downLatch.
	 */
	public CountDownLatch getDownLatch() {
		return downLatch;
	}

	/**
	 * @param downLatch The downLatch to set.
	 */
	public void setDownLatch(CountDownLatch downLatch) {
		this.downLatch = downLatch;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		downLatch.countDown();
	}
}

/*
 * 修改历史
 * $Log$ 
 */