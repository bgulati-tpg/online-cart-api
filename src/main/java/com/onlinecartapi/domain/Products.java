package com.onlinecartapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Products {
	@Id
	@Column(name = "product_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
	@Column(name = "product_uuid")
    private String uuid;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category_id")
    private  ProductCategory category;
	
	@Column(name = "name")
    private String name;
	
	@Column(name = "description")
    private String description;
	
	@Column(name = "average_rating")
    private Float rating;
	
	@Column(name = "price")
    private Integer price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
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

	@Override
	public String toString() {
		return "Products [id=" + id + ", uuid=" + uuid + ", name=" + name + ", description="
				+ description + ", rating=" + rating + ", price=" + price + "]";
	}
	
	
}