package com.onlinecartapi.dto;

public class ProductDetailDTO {

	String name;
	String description;
	Float rating;
	Integer price;
	String uuid;
	
	public ProductDetailDTO(String name, String description, Float rating, Integer price, String uuid) {
		this.name = name;
		this.description = description;
		this.rating = rating;
		this.price = price;
		this.uuid = uuid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Float getRating() {
		return rating;
	}
	public void setRating(Float rating) {
		this.rating = rating;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	
}
