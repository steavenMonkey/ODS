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

public class HtmlFilter implements IFilter{

	/* (non-Javadoc)
	 * @see example.desigepatten.chain.IFilter#dofilter(java.lang.String)
	 */
	public String dofilter(String str) {
		String r = str.replace('<', '{').replace('>', '}');
		return r;
	}

	/* (non-Javadoc)
	 * @see example.desigepatten.chain.IFilter#dofilter(example.desigepatten.chain.Request, example.desigepatten.chain.Response)
	 */
	public void dofilter(Request request, Response response, FilterChain chain) {
		request.request = request.getRequest().replace('<', '{').replace('>', '}') + "---htmlFilter";
		chain.doFilter(request,response);
		response.response += "----htmlFilter";
	}

}

/*
 * 修改历史
 * $Log$ 
 */