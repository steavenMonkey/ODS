package com.manyouyou.ordersystem.model;

import java.io.Serializable;

public class ProductInfoModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6606619195640972325L;
	
	private int productId;
	private String productName;
	private String price;
	private String standard;//产品规格
	private int storeNum;//库存
	private int saleNum;//销量
	private String remark;//备注
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public int getStoreNum() {
		return storeNum;
	}
	public void setStoreNum(int storeNum) {
		this.storeNum = storeNum;
	}
	public int getSaleNum() {
		return saleNum;
	}
	public void setSaleNum(int saleNum) {
		this.saleNum = saleNum;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "ProductInfoModel [productId=" + productId + ", productName="
				+ productName + ", price=" + price + ", standard=" + standard
				+ ", storeNum=" + storeNum + ", saleNum=" + saleNum
				+ ", remark=" + remark + "]";
	}
	
	
	

}
