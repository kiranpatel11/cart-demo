package com.example.cart.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
/**
 * Shopping Cart for the customer
 * 
 * @author kp7466
 *
 */
public class Cart {

	private String id;

	private List<CartItem> items = new ArrayList<>();
	
	private Cart() {
		super();
	}

	public Cart(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	private void setId(String id) {
		this.id = id;
	}

	public List<CartItem> getItems() {
		return Collections.unmodifiableList(items);
	}

	private void setItems(List<CartItem> items) {
		this.items = items;
	}	
	
	public void addItem(CartItem item) {
		this.items.add(item);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
