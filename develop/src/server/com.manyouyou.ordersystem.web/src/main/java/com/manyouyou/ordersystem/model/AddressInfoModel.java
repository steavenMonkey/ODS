package com.manyouyou.ordersystem.model;

import java.io.Serializable;

public class AddressInfoModel  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1592881245777818854L;
	
	private int addressId;
	private int customerId;
	private String address;
	private String remark;
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Override
	public String toString() {
		return "AddressInfoModel [addressId=" + addressId + ", customerId="
				+ customerId + ", address=" + address + ", remark=" + remark
				+ "]";
	}
	
	
	
	
}
