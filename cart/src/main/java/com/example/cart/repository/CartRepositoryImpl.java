package com.example.cart.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.example.cart.model.Cart;
import com.example.cart.repository.cache.CartCache;

@SuppressWarnings("unused")
@Repository
class CartRepositoryImpl implements CartRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(CartRepositoryImpl.class);
	
	private CartCache cartCache;
	
	@Autowired
	public CartRepositoryImpl(CartCache cache) {
		this.cartCache = cache;
	}

	@Override
	public Cart getCart(String cartId) {			
		return cartCache.get(cartId)
					.orElse(new Cart(cartId));
	}

	@Override
	public Cart saveCart(Cart cart) {				
		if(cart == null) {
			throw new IllegalArgumentException("cart cannot be null");
		}		
		return cartCache.put(cart);
	}
}
