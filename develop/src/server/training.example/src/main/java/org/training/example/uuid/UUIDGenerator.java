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
 * Created on 2015年5月28日
 *******************************************************************************/


package org.training.example.uuid;

import java.util.UUID;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public class UUIDGenerator {
	
	public static String gen(){
		String uuid = UUID.randomUUID().toString();
		String primaryKey = uuid.toString().replaceAll("-", "");
		return primaryKey;
	}
	
	public static void main(String[] args) {
		System.out.println(UUIDGenerator.gen());
	}
}

/*
 * 修改历史
 * $Log$ 
 */