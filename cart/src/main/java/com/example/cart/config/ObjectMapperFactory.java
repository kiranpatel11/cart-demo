package com.example.cart.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.smile.SmileFactory;

public class ObjectMapperFactory {
	
	//singleton
	private ObjectMapperFactory() {		
	}
	
	/*public static ObjectMapper smileMapper() {
	    return new ObjectMapper(new SmileFactory());
	}*/
	
	public static ObjectMapper objectMapper() {
	    return new ObjectMapper(new SmileFactory());
	}
}
