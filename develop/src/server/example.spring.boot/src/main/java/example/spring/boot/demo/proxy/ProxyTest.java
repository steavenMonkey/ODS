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

/**
 * TODO 此处填写 class 信息
 *
 * @author yourname (mailto:yourname@primeton.com)
 */

public class ProxyTest {
	public static void main(String[] args) {
		UserDao dao = new UserDaoImpl();
		MyInvocationHandler h = new MyInvocationHandler(dao);
		UserDao proxy =  (UserDao) h.getProxy();
		proxy.add();
	}
}

/*
 * 修改历史
 * $Log$ 
 */