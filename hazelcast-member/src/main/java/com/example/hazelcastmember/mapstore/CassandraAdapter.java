package com.example.hazelcastmember.mapstore;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * Adapter class to make CassandraRepository spring bean accessible from non-spring classes.
 * 
 * @author kp7466
 *
 */
@Component
class CassandraAdapter {
	
	private static CassandraAdapter instance;
	
	private CassandraRepository repository;
	
	@Autowired
	private CassandraAdapter(CassandraRepository repo) {
		this.repository = repo;
	}
	
	/**
	 * Initialize static instance
	 */
	@PostConstruct
	private void initialize() {
		instance = this;
	}	
	
	public static CassandraAdapter instance() {
		return instance;
	}
	
	public CassandraRepository getRepository() {
		return this.repository;
	}	
}
