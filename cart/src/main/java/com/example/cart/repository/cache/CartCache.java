package com.example.cart.repository.cache;

import java.util.Optional;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.example.cart.model.Cart;

@Component
public class CartCache {

	@Cacheable(value ="cartStore", unless="#result == null")
	public Optional<Cart> get(String cartId) {
		System.out.println("getCartObject called : " + cartId);
		return Optional.empty();
	}
	
	@CachePut(value ="cartStore", key="#result.id")
	public Cart put(Cart cart) {
		System.out.println("saveCartObject called : " + cart.getId());
		return cart;
	}
}
