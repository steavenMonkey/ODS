package com.manyouyou.ordersystem.model;

import java.io.Serializable;

public class CustomerInfoModel implements Serializable{
	  
	/**
	 * 
	 */
	private static final long serialVersionUID = 4162051053297667169L;
	
	private int customerId;
	private String customerName;
	private String phoneNum;//联系方式
	private String remark;//备注
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Override
	public String toString() {
		return "CustomerInfoModel [customerId=" + customerId
				+ ", customerName=" + customerName + ", phoneNum=" + phoneNum
				+ ", remark=" + remark + "]";
	}
	
	
}
