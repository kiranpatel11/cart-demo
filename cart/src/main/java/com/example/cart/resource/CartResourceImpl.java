package com.example.cart.resource;

import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.example.cart.model.Cart;
import com.example.cart.model.CartItem;
import com.example.cart.repository.CartRepository;

/**
 * This is the Controller class for User mService
 * 
 * @author LEGOS - Platform Team
 * @version $Id$
 * 
 */
@Component
public class CartResourceImpl implements CartResource {

	// TODO: remove hardcoding for Uri, instead use UriInfo injection
	// UriInfo injection is on hold due to unittest issue.
	private static String baseUrl = "/carts";

	@Autowired
	private CartRepository cartRepository;

	@Override
	public Response getCart(String cartId) {		
		Cart cart = cartRepository.getCart(cartId);

		// TODO: remove hardcoded link builder
		// Optional, if Hypermedia link to be included in the response
		Link link = Link.fromUri(baseUrl).rel("self").build(cartId);
		return Response.ok(cart).links(link).build();
	}

	@Override
	public Response addItem(String userId, CartItem item, UriInfo uriInfo) {		
		Cart cart = cartRepository.getCart(userId);		
		cart.addItem(item);
		Cart created = cartRepository.saveCart(cart);

		UriBuilder builder = uriInfo.getRequestUriBuilder();
		builder.path(created.getId());
		return Response.created(builder.build()).build();
	}

}