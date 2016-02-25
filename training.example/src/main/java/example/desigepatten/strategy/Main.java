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
 * Created on 2015年9月15日
 *******************************************************************************/


package example.desigepatten.strategy;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public class Main {
	public static void main(String[] args) {
		Comparable[] c = new Cat[]{new Cat(2,1),new Cat(1, 2)};
		DataSourtor.sort(c, new CatHeightComparator());
		
		DataSourtor.print(c);
	}
}

/*
 * 修改历史
 * $Log$ 
 */