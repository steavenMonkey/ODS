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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * TODO 此处填写 class 信息
 *
 * @author yourname (mailto:yourname@primeton.com)
 */
@SpringBootApplication
@ComponentScan("example.spring.boot.demo.aop")
public class Application implements CommandLineRunner{
	
	@Autowired
	private SampleService service;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/* (non-Javadoc)
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... args) throws Exception {
		service.sayHello();
	}
}

/*
 * 修改历史
 * $Log$ 
 */