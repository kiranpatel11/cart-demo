package com.example.cart.repository;

import java.io.Serializable;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import com.example.cart.model.Cart;

@Table("CART_BINARY")
class CartDataObject {
	
	@PrimaryKey("cart_id")
	private String id;
	
	@Column("cart_data")
	private Cart cart;

	/**
	 * default constructor, used for (de)serialization purpose
	 */
	private CartDataObject() {
		super();
	}

	public CartDataObject(Cart cart) {
		setCart(cart);
	}
	
	public String getId() {
		return id;
	}

	/**
	 * Used for (de)serialization only
	 *	
	 * @param id
	 */
	@SuppressWarnings("unused")
	public void setId(String id) {
		this.id = id;
	}

	public Cart getCart() {
		return cart;
	}

	private void setCart(Cart cart) {
		this.cart = cart;
		this.id = cart.getId();
	}	
	
}
