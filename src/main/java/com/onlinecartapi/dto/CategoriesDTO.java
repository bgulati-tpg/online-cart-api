package com.onlinecartapi.dto;

public class CategoriesDTO {

	String name;
	String uuid;
	String url;
	
	public CategoriesDTO(String name, String uuid, String url) {
		this.name = name;
		this.uuid = uuid;
		this.url = url;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
