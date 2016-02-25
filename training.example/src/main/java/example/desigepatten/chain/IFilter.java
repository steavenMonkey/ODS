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
 * Created on 2015年9月12日
 *******************************************************************************/


package example.desigepatten.chain;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public interface IFilter {
	String dofilter(String str);
	
	void dofilter(Request request, Response response, FilterChain chain);
}

/*
 * 修改历史
 * $Log$ 
 */