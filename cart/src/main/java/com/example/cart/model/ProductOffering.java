package com.example.cart.model;

import java.io.Serializable;

public class ProductOffering {
	
	private String sku;
	
	private String Category;
	
	private String type;

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
