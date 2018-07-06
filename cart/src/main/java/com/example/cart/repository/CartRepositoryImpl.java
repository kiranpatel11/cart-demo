package com.example.cart.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.cart.model.Cart;
import com.example.cart.repository.cache.CartCache;

@Repository
class CartRepositoryImpl implements CartRepository {
	
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
		return cartCache.put(cart);
	}
}
