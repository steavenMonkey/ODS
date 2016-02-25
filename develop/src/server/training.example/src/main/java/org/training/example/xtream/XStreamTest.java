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
 * Created on 2015年5月25日
 *******************************************************************************/


package org.training.example.xtream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public class XStreamTest {
	
	@Test
	public void toXMLTest(){
		XStream xstream = new XStream(new DomDriver());
		Person p = new Person();
		p.setAge(1);
		p.setName("name");
		List<Person> friends = new ArrayList<Person>();
		Person f1 = new Person();
		f1.setName("f1");
		p.setFriends(friends);
		Map<String, String> phones = new ConcurrentHashMap<String, String>();
		phones.put("1", "1234");
		p.setPhones(phones);
		House h = new House();
		h.setId(2);
		h.setName("h");
		p.setHouse(h);
		
		String px = xstream.toXML(p);
		System.out.println(px);
		
	}
}

/*
 * 修改历史
 * $Log$ 
 */