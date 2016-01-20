package com.manyouyou.ordersystem.model;

import java.io.Serializable;
import java.util.Date;

public class OrderModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4357156422156373690L;
	
	private int orderId;
	  private int productId;
	  private int orderNum;
	  private String consumerName;
	  private String receiveAddress;
	  private String cPhoneNum;
	  private int hasDeliver;
	  private int hasPay;
	  private Date orderDate;
	  private String deliverCompany;
	  private String deliverNum;
	  private String remark;//备注
	  private int salerId;//卖家ID
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public String getConsumerName() {
		return consumerName;
	}
	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}
	public String getReceiveAddress() {
		return receiveAddress;
	}
	public void setReceiveAddress(String receiveAddress) {
		this.receiveAddress = receiveAddress;
	}
	public String getcPhoneNum() {
		return cPhoneNum;
	}
	public void setcPhoneNum(String cPhoneNum) {
		this.cPhoneNum = cPhoneNum;
	}
	public int getHasDeliver() {
		return hasDeliver;
	}
	public void setHasDeliver(int hasDeliver) {
		this.hasDeliver = hasDeliver;
	}
	public int getHasPay() {
		return hasPay;
	}
	public void setHasPay(int hasPay) {
		this.hasPay = hasPay;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getDeliverCompany() {
		return deliverCompany;
	}
	public void setDeliverCompany(String deliverCompany) {
		this.deliverCompany = deliverCompany;
	}
	public String getDeliverNum() {
		return deliverNum;
	}
	public void setDeliverNum(String deliverNum) {
		this.deliverNum = deliverNum;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getSalerId() {
		return salerId;
	}
	public void setSalerId(int salerId) {
		this.salerId = salerId;
	}
	
	@Override
	public String toString() {
		return "OrderModel [orderId=" + orderId + ", productId=" + productId
				+ ", orderNum=" + orderNum + ", consumerName=" + consumerName
				+ ", receiveAddress=" + receiveAddress + ", cPhoneNum="
				+ cPhoneNum + ", hasDeliver=" + hasDeliver + ", hasPay="
				+ hasPay + ", orderDate=" + orderDate + ", deliverCompany="
				+ deliverCompany + ", deliverNum=" + deliverNum + ", remark="
				+ remark + ", salerId=" + salerId + "]";
	}
	
	  
}
