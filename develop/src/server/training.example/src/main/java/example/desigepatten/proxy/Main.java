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

public class Main {
	public static void main(String[] args) {
		IMoveable tank = new Tank();

		TankLogProxy tlp  = new TankLogProxy(tank);
		TankTimerProxy ttp = new TankTimerProxy(tlp);
		ttp.move();
	}
}

/*
 * 修改历史
 * $Log$ 
 */