package com.example.cart.repository.cassandra;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.cassandra.core.convert.CassandraCustomConversions;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import com.example.cart.config.ObjectMapperFactory;
import com.example.cart.model.Cart;

@Configuration
@EnableCassandraRepositories(basePackages = "com.example.cart.repository")
class CassandraConverterConfig {

	@Bean
	public CassandraCustomConversions customConversions() {

		List<Converter<?, ?>> converters = new ArrayList<>();
		converters.add(new CartWriteConverter());
		converters.add(new CartReadConverter());

		return new CassandraCustomConversions(converters);
	}
	
	/**
	 * Write a {@link Contact} into its {@link String} representation.
	 */
	static class CartWriteConverter implements Converter<Cart, ByteBuffer> {

		public ByteBuffer convert(Cart source) {

			try {
				return ByteBuffer.wrap(ObjectMapperFactory.objectMapper().writeValueAsBytes(source));
			} catch (IOException e) {
				throw new IllegalStateException(e);
			}
		}
	}
	
	/**
	 * Read a {@link Contact} from its {@link String} representation.
	 */
	static class CartReadConverter implements Converter<ByteBuffer, Cart> {

		public Cart convert(ByteBuffer source) {

			if (source != null) {
				try {
					return ObjectMapperFactory.objectMapper().readValue(source.array(), Cart.class);
				} catch (IOException e) {
					throw new IllegalStateException(e);
				}
			}
			return null;
		}
	}	
/*	*//**
	 * Write a {@link Contact} into its {@link String} representation.
	 *//*
	static class CartWriteConverter implements Converter<Cart, String> {

		public String convert(Cart source) {

			try {
				return ObjectMapperFactory.smileMapper().writeValueAsString(source);
			} catch (IOException e) {
				throw new IllegalStateException(e);
			}
		}
	}
	
	*//**
	 * Read a {@link Contact} from its {@link String} representation.
	 *//*
	static class CartReadConverter implements Converter<String, Cart> {

		public Cart convert(String source) {

			if (StringUtils.hasText(source)) {
				try {
					return ObjectMapperFactory.smileMapper().readValue(source, Cart.class);
				} catch (IOException e) {
					throw new IllegalStateException(e);
				}
			}
			return null;
		}
	}
*/}
