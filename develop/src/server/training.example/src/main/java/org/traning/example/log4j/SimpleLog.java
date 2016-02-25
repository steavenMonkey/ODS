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
 * Created on 2015年5月13日
 *******************************************************************************/


package org.traning.example.log4j;

import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public class SimpleLog {
	
	private static ConcurrentHashMap<String, Logger> logCache = new ConcurrentHashMap<String, Logger>();
	
	public static Logger getLogger(String file){
		
		Logger log = logCache.get(file);
		if(null != log){
			return log;
		}else{
			log = Logger.getLogger(file);
			DailyRollingFileAppender appender = new DailyRollingFileAppender();
			Layout layout = new PatternLayout();
			appender.setFile(file);
			appender.setEncoding("UTF-8");
			appender.activateOptions();
			appender.setDatePattern("'.'yyyy-MM-dd");
			appender.setLayout(layout);
			log.addAppender(appender);
			logCache.put(file, log);
		}
		
		return log;
	}
	
	
	public static void backup(String file,String info){
		Logger log = getLogger(file);
		log.info(info);
	}
}

/*
 * 修改历史
 * $Log$ 
 */