package com.onlinecartapi.dto;

public class OrderHistoryDto {

	private Long orderId;

	private String productName;

	private Long customerId;

	private Double totalAmount;
	
	public OrderHistoryDto()  {
		
	}
	
	public OrderHistoryDto(Long orderId, String productName, Long customerId, Double totalAmount) {
		this.orderId = orderId;
		this.productName = productName;
		this.customerId = customerId;
		this.totalAmount = totalAmount;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

}
