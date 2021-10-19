package com.onlinecartapi.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class OrderProduct {
	@Id
	@Column(name = "order_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long orderId;
	@Column(name = "product_name")
	private String product_name;
	@Column(name = "date_time")
	private Date date;
	@Column(name = "total_amount")
	private double totalAmount;
	@OneToOne(mappedBy="orderId",cascade = CascadeType.ALL,fetch=FetchType.LAZY,optional=false)
	private DeliveryAddress deliveryId;
	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "usr_id")
	private User customerId;
	
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public User getCustomerId() {
		return customerId;
	}
	public void setCustomerId(User customerId) {
		this.customerId = customerId;
	}
	
	

}
