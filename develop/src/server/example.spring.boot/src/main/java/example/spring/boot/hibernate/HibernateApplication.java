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
 * Created on 2016年7月6日
 *******************************************************************************/


package example.spring.boot.hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import example.spring.boot.restful.demo.mvc.BootRestDemo;

/**
 * TODO 此处填写 class 信息
 *
 * @author yourname (mailto:yourname@primeton.com)
 */

@SpringBootApplication
@ComponentScan("example.spring.boot.hibernate")
public class HibernateApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BootRestDemo.class, args);
	}
}

/*
 * 修改历史
 * $Log$ 
 */