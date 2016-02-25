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
 * Created on 2015年9月13日
 *******************************************************************************/


package example.desigepatten.proxy;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public class TankTimerProxy implements IMoveable{
	
	private IMoveable m;
	
	public TankTimerProxy(IMoveable m) {
		this.m = m;
	}

	/* (non-Javadoc)
	 * @see example.desigepatten.proxy.IMoveable#move()
	 */
	public void move() {
		long start = System.currentTimeMillis();
		System.out.println("start time: " + start);
		m.move();
		long end = System.currentTimeMillis();
		System.out.println("end time: " + end);
		System.out.println(end-start);
	}

}

/*
 * 修改历史
 * $Log$ 
 */