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

public class Main {
	public static void main(String[] args) {
		String msg = "大家好:), <script>, 敏感,被就业,网络授课没感觉,因为看不见大家伙";
//		MsgProcessor mp = new MsgProcessor();
//		mp.setMsg(msg);
//		FilterChain chain = new FilterChain();
//		chain.addFilter(new HtmlFilter()).addFilter(new SensitiveFilter());
//		mp.setChain(chain);
//		String result = mp.process();
//		System.out.println(result);
		
		FilterChain chain = new FilterChain();
		chain.addFilter(new HtmlFilter()).addFilter(new SensitiveFilter());
		Request res = new Request();
		res.setRequest(msg);
		Response req = new Response();
		req.setResponse("response");
		
		chain.doFilter(res,req);
		System.out.println(res.getRequest());
		System.out.println(req.getResponse());
	}
}

/*
 * 修改历史
 * $Log$ 
 */