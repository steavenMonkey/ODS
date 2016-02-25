package com.manyouyou.ordersystem.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userinfo")
public class UserInfoModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8080222678483193579L;
	
	private int userId;
	private String name;
	private String password;
	private String phoneNum;
	
	
	@Id
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Column(name="username")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	@Override
	public String toString() {
		return "UserInfoModel [userId=" + userId + ", name=" + name
				+ ", password=" + password + ", phoneNum=" + phoneNum + "]";
	}
	
	
	
	
	
}
