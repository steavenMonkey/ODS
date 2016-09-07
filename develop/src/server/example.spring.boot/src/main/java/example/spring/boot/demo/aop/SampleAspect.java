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

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * TODO 此处填写 class 信息
 *
 * @author yourname (mailto:yourname@primeton.com)
 */

@Aspect
@Component
public class SampleAspect {
	
	@Pointcut("execution(* example.spring.boot.demo.aop.*Service.*(..))")
	public void logPoint(){}
	
	@Before("logPoint()")
	public void before(JoinPoint jpoint){
		System.out.println("log before method invoke........" + jpoint);
	}
	
	
}

/*
 * 修改历史
 * $Log$ 
 */