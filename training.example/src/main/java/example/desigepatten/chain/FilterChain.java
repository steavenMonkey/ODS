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

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public class FilterChain {
	List<IFilter> filterList = new ArrayList<IFilter>();
	
	int i = 0;
	
	public void doFilter(Request request, Response response){
		if(i>=filterList.size()){
			return;
		}
		IFilter f = filterList.get(i);
		i++;
		f.dofilter(request, response,this);
	}
	
	public String doFilter(String msg){
		for (IFilter iFilter : filterList) {
			msg = iFilter.dofilter(msg);
		}
		return msg;
	}

	
	public FilterChain addFilter(IFilter filter){
		this.filterList.add(filter);
		return this;
	}
	
}

/*
 * 修改历史
 * $Log$ 
 */