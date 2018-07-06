package com.example.cart.repository.cache;

import java.io.IOException;

import com.example.cart.config.ObjectMapperFactory;
import com.example.cart.model.Cart;
import com.hazelcast.nio.serialization.ByteArraySerializer;

class CartCacheSerializer implements ByteArraySerializer<Cart> {

	@Override
	public void destroy() {
		
	}

	@Override
	public int getTypeId() {
		return 1;
	}

	@Override
	public Cart read(byte[] bytes) throws IOException {
		System.out.println("CartCacheSerializer.read()..." + bytes.length);
		return ObjectMapperFactory.objectMapper().readValue(bytes, Cart.class);
	}

	@Override
	public byte[] write(Cart cart) throws IOException {
		System.out.println("CartCacheSerializer.write()..." + cart.getId());
		return ObjectMapperFactory.objectMapper().writeValueAsBytes(cart);
	}
}
