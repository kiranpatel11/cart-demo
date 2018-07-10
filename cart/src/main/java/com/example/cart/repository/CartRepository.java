package com.example.cart.repository;

import org.springframework.stereotype.Repository;

import com.example.cart.model.Cart;

@Repository
public interface CartRepository {
	
	public Cart getCart(String cartId);

	public Cart saveCart(Cart cart);
} 
