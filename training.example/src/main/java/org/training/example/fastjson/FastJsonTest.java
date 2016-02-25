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
 * Created on 2015年6月2日
 *******************************************************************************/


package org.training.example.fastjson;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public class FastJsonTest {
	
	private Student s = null;
	
	@Before
	public void init(){
		s = new Student();
		s.setName("xiaoming");
//		s.setContext(new Date());
		Map<String, String> extensions = new HashMap<String, String>();
		extensions.put("1", "1");
		Teacher t = new Teacher();
		t.setAge(1);
		t.setName("teacher");
		t.setNums(extensions);
		s.setExtensions(extensions);
		s.setTeacher(t);
	}
	
	
	@Test
	public void object2JsonTest(){
		String str = JSON.toJSONString(s);
		System.out.println(str);
		
	}
	
	@Test
	public void json2Object(){
		String json = "{\"context\":1434511346783,\"extensions\":{\"1\":\"1\"},\"name\":\"xiaoming\",\"teacher\":{\"age\":1,\"name\":\"teacher\",\"nums\":{\"$ref\":\"$.extensions\"}}}\n" + 
				"";
//		JSON.toJavaObject(json, Student.class);
		Student student = JSON.parseObject(json, Student.class);
		System.out.println(student.getName());
		System.out.println(student.getExtensions().get("1"));
		System.out.println(student.getContext());
	}
}

/*
 * 修改历史
 * $Log$ 
 */