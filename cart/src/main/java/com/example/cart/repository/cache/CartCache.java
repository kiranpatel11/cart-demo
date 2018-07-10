package com.example.cart.repository.cache;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.example.cart.model.Cart;

@Component
public class CartCache {
	
	private static final Logger logger = LoggerFactory.getLogger(CartCache.class);

	@Cacheable(value ="cartStore", unless="#result == null")
	public Optional<Cart> get(String cartId) {
		logger.debug("getCartObject called : " + cartId);
		return Optional.empty();
	}
	
	@CachePut(value ="cartStore", key="#result.id")
	public Cart put(Cart cart) {
		logger.debug("saveCartObject called : " + cart.getId());
		return cart;
	}
}
