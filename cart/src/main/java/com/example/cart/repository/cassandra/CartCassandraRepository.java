package com.example.cart.repository.cassandra;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Package default interface, restricted only within repository package
 * 
 * @author kp7466
 */
@Repository
interface CartCassandraRepository extends CrudRepository<CartDataObject, String> {
	
	@SuppressWarnings("unchecked")
	@Override
	CartDataObject save(CartDataObject cart);
	
	@Override
	Optional<CartDataObject> findById(String id);
}
