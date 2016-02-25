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


package org.training.example.timstampe;

import java.text.SimpleDateFormat;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public class TimeStampeTest {
	public static String DEFAULT_TIME_PATTERN="yyyyMMddHHmmssSSS";
	
	public static void main(String[] args) {
		SimpleDateFormat sdf = SimpleDateFormatHolder.getThreadLocalSimpleDateFormat(DEFAULT_TIME_PATTERN);
//		Date dt = sdf.parse(timeString);
//		rdt.getTime();
	}
}

/*
 * 修改历史
 * $Log$ 
 */