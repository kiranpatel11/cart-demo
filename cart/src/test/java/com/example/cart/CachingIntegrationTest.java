package com.example.cart;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.cart.model.Cart;
import com.example.cart.repository.CartRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration
public class CachingIntegrationTest {

	@Autowired
	CartRepository repo;

	@Autowired
	CacheManager manager;

	@Test
	public void methodInvocationShouldBeCached() {

		Cart first = new Cart("foo");
		Cart second = new Cart("bar");

		// Set up the mock to return *different* objects for the first and second call
		Mockito.when(repo.getCart(Mockito.any(String.class))).thenReturn(first, second);

		// First invocation returns object returned by the method
		Object result = repo.getCart("foo");
		assertThat(result, is(first));

		// Second invocation should return cached value, *not* second (as set up above)
		result = repo.getCart("foo");
		assertThat(result, is(first));

		// Verify repository method was invoked once
		//Mockito.verify(repo, Mockito.times(1)).findById("foo");
		assertThat(manager.getCache("carts").get("foo"), is(notNullValue()));

		// Third invocation with different key is triggers the second invocation of the
		// repo method
		result = repo.getCart("bar");
		assertThat(result, is(second));
		
		assertThat(manager.getCache("carts").get("bar"), is(notNullValue()));
		
		// Verify repository method was invoked for bar
		verify(repo, Mockito.times(1)).getCart("foo");
	}
	
	
	@Configuration
	@EnableCaching
	static class Config {

		// A repository mock instead of the real proxy
		@Bean
		CartRepository myRepo() {
			return Mockito.mock(CartRepository.class);
		}

		@Bean
		public CacheManager cacheManager() {
			return new ConcurrentMapCacheManager("carts");
		}
	}

}


