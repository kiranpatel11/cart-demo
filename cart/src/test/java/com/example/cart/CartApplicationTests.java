package com.example.cart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.cart.model.Cart;
import com.example.cart.model.CartItem;
import com.example.cart.model.ProductOffering;
import com.example.cart.repository.CartRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Value("${cartTTL}")
	private String cartTTL;
	
	@Autowired
	CartRepository repository;
	
	@Test
	public void testCartRepository() {
			
		assertEquals("30000", cartTTL);
		
		Cart cart = createCartObject();
		
		Cart saved = repository.saveCart(cart);
		
		assertNotNull(saved);		
		
		Cart fetched = repository.getCart(cart.getId());
		assertNotNull(fetched);		
		assertEquals(fetched.getId(), cart.getId());		
		assertEquals(fetched.getItems().size(), cart.getItems().size());		
	}
	
	private Cart createCartObject() {
		
		ProductOffering device = new ProductOffering();
		device.setSku("12345");
		device.setCategory("Wireless");
		device.setType("Device");
		
		ProductOffering plan = new ProductOffering();
		plan.setSku("54321");
		plan.setCategory("Wireless");
		plan.setType("Plan");

		Cart cart = new Cart("11112222");
		cart.addItem(new CartItem(device, 1));
		cart.addItem(new CartItem(plan, 1));		
		return cart;
	}

}
