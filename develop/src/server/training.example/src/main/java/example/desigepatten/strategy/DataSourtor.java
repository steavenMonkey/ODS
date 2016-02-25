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

public class DataSourtor {

	/**
	 * @param c
	 */
	public static void sort(Comparable[] c,Comparator comparator) {

		for(int i=c.length;i>0;i--){
			for(int j=0;j<i-1;i++){
				if(comparator.compareto(c[j], c[j+1]) > 0){
					swap(c,j,j+1);
				}
			}
		}
	}


	/**
	 * @param c
	 * @param j
	 * @param i
	 */
	private static void swap(Comparable[] c, int x, int y) {

		Comparable temp = c[x];
		c[x] = c[y];
		c[y] = temp;
		
	}


	/**
	 * @param c
	 */
	public static void print(Comparable[] c) {
		for (Comparable comparable : c) {
			System.out.println(comparable);
		}
	}
	
	public static void main(String[] args) {
		int[] c = new int[]{1,5,3,8,7};
		for(int i=c.length;i>0;i--){
			for(int j=0;j<i-1;j++){
				if(c[j]>c[j+1]){
					int temp = c[j];
					c[j] = c[j+1];
					c[j+1] = temp;
				}
			}
		}
		
		for(int a : c){
			System.out.println(a);
		}
	}
}

/*
 * 修改历史
 * $Log$ 
 */