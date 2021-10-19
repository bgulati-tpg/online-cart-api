package com.onlinecartapi.dto;

import java.util.List;

public class OrderInfoDto {
	private List<OrderedProductDTO> orderedProduct;
	public List<OrderedProductDTO> getOrderedProduct() {
		return orderedProduct;
	}
	public void setOrderedProduct(List<OrderedProductDTO> orderedProduct) {
		this.orderedProduct = orderedProduct;
	}
	private String fuullName;
	private String phone;
	private String address1;
	private String address2;
	private String city;
	private String state;
	
	public String getFuullName() {
		return fuullName;
	}
	public void setFuullName(String fuullName) {
		this.fuullName = fuullName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	private String pincode;
	

}
