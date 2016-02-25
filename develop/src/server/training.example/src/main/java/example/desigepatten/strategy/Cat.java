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

public class Cat implements Comparable{
	private int height;
	
	private int weight;
	
	
	/**
	 * @param height
	 * @param weight
	 */
	public Cat(int height, int weight) {
		super();
		this.height = height;
		this.weight = weight;
	}

	private Comparator comparator;

	/**
	 * @return Returns the height.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height The height to set.
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return Returns the weight.
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight The weight to set.
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/* (non-Javadoc)
	 * @see example.desigepatten.strategy.Comparable#compareTo(java.lang.Object, java.lang.Object)
	 */
	public int compareTo(Object c) {
		
		return 0;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.height + "|" + this.weight;
	}
	
	
	
}

/*
 * 修改历史
 * $Log$ 
 */