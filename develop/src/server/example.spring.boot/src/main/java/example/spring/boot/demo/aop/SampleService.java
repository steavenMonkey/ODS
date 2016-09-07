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
 * Created on 2016年9月5日
 *******************************************************************************/


package example.spring.boot.demo.aop;

import org.springframework.stereotype.Component;

/**
 * TODO 此处填写 class 信息
 *
 * @author yourname (mailto:yourname@primeton.com)
 */

@Component
public class SampleService {
	
	public String sayHello(){
		System.out.println("execute method sayHello......");
		return "hello world";
	}
}

/*
 * 修改历史
 * $Log$ 
 */