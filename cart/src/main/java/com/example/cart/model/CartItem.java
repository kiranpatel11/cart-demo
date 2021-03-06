package com.example.cart.model;

public class CartItem {
	
	private ProductOffering productOffering;
	
	private int quantity;
	
	@SuppressWarnings("unused")
	private CartItem() {
		super();
	}

	public CartItem(ProductOffering productOffering, int quantity) {
		super();
		this.productOffering = productOffering;
		this.quantity = quantity;
	}

	public ProductOffering getProductOffering() {
		return productOffering;
	}

	public void setProductOffering(ProductOffering productOffering) {
		this.productOffering = productOffering;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
