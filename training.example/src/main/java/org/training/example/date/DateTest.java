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
 * Created on 2015年6月5日
 *******************************************************************************/


package org.training.example.date;

import java.text.SimpleDateFormat;

import org.junit.Test;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public class DateTest {
	
	@Test
	public void compareDate(){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		long nowC = System.currentTimeMillis();
		System.out.println(nowC);
		long x = 2*24*60*60*1000;
		System.out.println(x);
		System.out.println(nowC+x);
		String now = sf.format((System.currentTimeMillis()+x));
		System.out.println(now);
	}
	
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
	}
}

/*
 * 修改历史
 * $Log$ 
 */