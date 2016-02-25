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

public class MsgProcessor {
	private String msg;
//	private List<IFilter> filters = new ArrayList<IFilter>();
	private FilterChain chain;
	
	
	public String process(){
		
		return chain.doFilter(msg);
	}
	
	

	/**
	 * @return Returns the chain.
	 */
	public FilterChain getChain() {
		return chain;
	}



	/**
	 * @param chain The chain to set.
	 */
	public void setChain(FilterChain chain) {
		this.chain = chain;
	}



	/**
	 * @return Returns the msg.
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg The msg to set.
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}

/*
 * 修改历史
 * $Log$ 
 */