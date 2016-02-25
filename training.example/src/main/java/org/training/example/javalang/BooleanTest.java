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
 * Created on 2015年6月18日
 *******************************************************************************/


package org.training.example.javalang;

import java.util.concurrent.CountDownLatch;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public class BooleanTest {
	public static void main(String[] args) {
//		Object j = null;
//		Boolean flag = (Boolean) j;
//		System.out.println(flag);
		CountDownLatch downLatch = new CountDownLatch(4);
		S s = new S();
		S w = new S();
		s.setDownLatch(downLatch);
		
		w.setDownLatch(downLatch);
		
		
		
	}
}

/*
 * 修改历史
 * $Log$ 
 */