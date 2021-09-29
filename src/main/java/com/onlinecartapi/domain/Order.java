package com.onlinecartapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="orders")
//@NamedQuery(name="Order.findAllByUserId", query="SELECT o FROM Order o where o.user.usrId = :id") 
public class Order {
	@Id
	@Column(name = "order_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long orderId;
    
	@Column(name = "product_name")
    private String productName;
	
	@ManyToOne()
	@JoinColumn(name="customer_id", referencedColumnName="usr_id")
    private  User customerId;
	
	@Column(name = "total_amount")
    private Double totalAmount;

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

	public User getCustomerId() {
		return customerId;
	}

	public void setCustomerId(User customerId) {
		this.customerId = customerId;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productName=" + productName + ", customerId=" + customerId
				+ ", totalAmount=" + totalAmount + "]";
	}

}