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

import java.util.List;
import java.util.Map;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public class Person {
	private String name;
	private int age;
	private List<Person> friends;
	private Map<String,String> phones;
	private House house;
	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return Returns the age.
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age The age to set.
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return Returns the friends.
	 */
	public List<Person> getFriends() {
		return friends;
	}
	/**
	 * @param friends The friends to set.
	 */
	public void setFriends(List<Person> friends) {
		this.friends = friends;
	}
	/**
	 * @return Returns the phones.
	 */
	public Map<String, String> getPhones() {
		return phones;
	}
	/**
	 * @param phones The phones to set.
	 */
	public void setPhones(Map<String, String> phones) {
		this.phones = phones;
	}
	/**
	 * @return Returns the house.
	 */
	public House getHouse() {
		return house;
	}
	/**
	 * @param house The house to set.
	 */
	public void setHouse(House house) {
		this.house = house;
	}
	
	
}

/*
 * 修改历史
 * $Log$ 
 */