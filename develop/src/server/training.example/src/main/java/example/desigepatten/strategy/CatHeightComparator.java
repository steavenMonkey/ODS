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
 * Created on 2015年9月16日
 *******************************************************************************/


package example.desigepatten.strategy;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public class CatHeightComparator implements Comparator{

	/* (non-Javadoc)
	 * @see example.desigepatten.strategy.Comparator#compareto(java.lang.Object, java.lang.Object)
	 */
	public int compareto(Object source, Object target) {
		Cat cat = (Cat) source;
		Cat cat2 = (Cat) target;
		if(cat.getHeight() > cat2.getHeight()){
			return 1;
		}else if(cat.getHeight() < cat2.getHeight()){
			return -1;
		}
		return 0;
	}


}

/*
 * 修改历史
 * $Log$ 
 */