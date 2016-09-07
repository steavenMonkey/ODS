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
 * Created on 2016年9月7日
 *******************************************************************************/


package example.spring.boot.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * TODO 此处填写 class 信息
 *
 * @author yourname (mailto:yourname@primeton.com)
 */

public class MyInvocationHandler implements InvocationHandler{
	
	private Object target;
	
	/**
	 * @param target
	 */
	public MyInvocationHandler(Object target) {
		super();
		this.target = target;
	}



	/* (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("befor---------------");
		Object ret = method.invoke(target, args);
		System.out.println("after---------------");
		return ret;
	}
	
	
	public Object getProxy(){
		return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(), this);
	}
}

/*
 * 修改历史
 * $Log$ 
 */