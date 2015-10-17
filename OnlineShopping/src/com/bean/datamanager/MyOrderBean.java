package com.bean.datamanager;

public class MyOrderBean {
	
	private int orderId;
	private String userName;
	private float allPrice;
	
	public MyOrderBean(){
		
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public float getAllPrice() {
		return allPrice;
	}
	public void setAllPrice(float allPrice) {
		this.allPrice = allPrice;
	}
}
