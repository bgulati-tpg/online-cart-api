package com.onlinecartapi.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product_category")
public class ProductCategory {
	@Id
	@Column(name = "category_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
	@Column(name = "category_name")
    private String name;
	
	@Column(name = "category_uuid")
	private String uuid;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "category")
    private Set<Products> products;
	
	@Column(name = "image_url")
	private String url;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Set<Products> getProducts() {
		return products;
	}

	public void setProducts(Set<Products> products) {
		this.products = products;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "ProductCategory [id=" + id + ", name=" + name + ", uuid=" + uuid +"]";
	}
	
	
}
