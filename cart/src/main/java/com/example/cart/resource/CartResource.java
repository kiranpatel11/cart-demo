package com.example.cart.resource;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.example.cart.model.CartItem;

/**
 * This is the Interface definition for Cart mService
 * 
 * @author LEGOS - Platform Team
 * @version $Id$
 * 
 */
@Path("/cart")
@Produces({MediaType.APPLICATION_JSON})
public interface CartResource {
	
    /**
     * Get cart of this user. 
     * This user is represented by the authentication token in header.
     * Please note, the guest(non-registered) users too have authentication token to uniquely represent the user in context.
     * 
     * By domain, there is 1 to 1 relationship between a user and an active cart.
     *
     * @param userId - Id of the authenticated user
     * 
     * @return Cart - Returns the details of the carts being searched
     */
	@GET
	@Path("/my")
	public Response getCart(@HeaderParam("userId") String userId);
	
	/**
     * Add items to 'this' user's cart
     *
     * @param item- item to be added to this user's cart
     * 
     * @param uriInfo - Request URI information, injected from {@link Context}
     * 
     * @return Cart - Returns the details of the cart created
     */
	@POST
	@Path("/my/items")
	public Response addItem(
				@HeaderParam("userId") String userId,
				CartItem item,
				@Context UriInfo uriInfo);	
}