/*******************************************************************************
 * $Header: /cvsroot/PTP50/workdir/bps/develop/src/server/com.primeton.bps.commons.utility/src/main/java/com/primeton/workflow/commons/utility/SimpleDateFormatHolder.java,v 1.1 2013/10/11 17:29:55 haoyf Exp $
 * $Revision: 1.1 $
 * $Date: 2013/10/11 17:29:55 $
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2006 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2010-10-27
 *******************************************************************************/

package org.training.example.timstampe;

import java.text.SimpleDateFormat;
import java.util.HashMap;

/**
 * TODO 此处填写 class 信息
 *
 * @author LiuHang (mailto:liuhang@primeton.com)
 */
/*
 * 修改历史
 * $Log: SimpleDateFormatHolder.java,v $
 * Revision 1.1  2013/10/11 17:29:55  haoyf
 * add: java 2 maven
 *
 * Revision 1.2  2013/09/04 13:34:06  wuyh
 * update:代码编码转换为UTF-8
 *
 * Revision 1.1  2013/08/23 11:38:16  wuyh
 * update:代码迁移 PTP5.0
 *
 * Revision 1.1  2013/08/22 12:59:57  wuyh
 * update:代码迁移 PTP5.0
 *
 * Revision 1.1  2013/08/21 10:51:38  wuyh
 * update:代码迁移 PTP5.0
 *
 * Revision 1.1  2011/03/25 07:42:20  tenghao
 * Update 性能优化
 *
 * Revision 1.1  2010/10/27 03:10:28  liuhang
 * Update:resolve simpledateformate performance problem
 * 
 */
public class SimpleDateFormatHolder {

	private static final String NULL_PATTERN = "_null";
	private static ThreadLocal<HashMap<String, SimpleDateFormat>>  mapTable = new ThreadLocal<HashMap<String, SimpleDateFormat>>(){

		@Override
		protected HashMap<String, SimpleDateFormat> initialValue() {
			return new HashMap<String,SimpleDateFormat>();
		}
		
	};

	public static SimpleDateFormat getThreadLocalSimpleDateFormat(String pattern) {
		if (pattern==null){
			pattern = NULL_PATTERN;
		}
		
		HashMap<String, SimpleDateFormat> map = mapTable.get();
		SimpleDateFormat obj = map.get(pattern);
		if (obj!=null)
			return obj;
		
		//make pattern
		if (pattern.equals(NULL_PATTERN)){
			obj = new SimpleDateFormat();
		}else{
			obj = new SimpleDateFormat(pattern);
		}
		
		map.put(pattern, obj);
		return obj;
	}
	
	public static void main(String[] args) {
		getThreadLocalSimpleDateFormat("yyyyMMdd");
		getThreadLocalSimpleDateFormat("yyyyMMdd");
		getThreadLocalSimpleDateFormat("yyyyMMdd");
		
		getThreadLocalSimpleDateFormat(null);
		getThreadLocalSimpleDateFormat(null);
	}
}
