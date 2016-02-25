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
 * Created on 2015年5月9日
 *******************************************************************************/


package org.training.example.list;

import java.util.ArrayList;
import java.util.List;


/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public class ListAddAndRemove {
	public static void main(String[] args) {
		List<Integer> ids = new ArrayList<Integer>();
		for(int i=0;i<10;i++){
			ids.add(i);
		}
		
		List<Integer> backupIds = new ArrayList<Integer>();
		for(int i=0;i<5;i++){
			int a = ids.remove(i);
			System.out.println(a);
		}
		
		for (Integer integer : ids) {
			System.out.println("--"+integer);
		}
		
	}
}

/*
 * 修改历史
 * $Log$ 
 */