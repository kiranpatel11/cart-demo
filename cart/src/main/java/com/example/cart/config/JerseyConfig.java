package com.example.cart.config;

import java.util.logging.Logger;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.cart.resource.CartResource;
import com.example.cart.resource.CartResourceImpl;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


/**
 * This Class reads and sets all configuration related to Jersey
 * 
 * 
 */
@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
	
	/*Please do not edit or remove the LOGGER_NAME name declaration as it is critical
	*to have this identifier for server side logging
	*/	
	public final static String LOGGER_NAME="com.att.idp.logging.server.JerseyLogging";
	private static final Logger log = Logger.getLogger(LOGGER_NAME);
	
    /**
     * This method creates an objectmapper and sets configuration related
     * to serialization 
     * 
     * @return objectMapper
     */
	@Bean
	@Primary
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		objectMapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
		objectMapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
		return objectMapper;
	}


    /**
     * This is the main constructor which register the Jersey configs 
     * 
     */
    public JerseyConfig() {
		//packages(CartResource.class.getPackage().toString());
		register(CartResourceImpl.class);
        property(ServletProperties.FILTER_FORWARD_ON_404, true);
        register(new LoggingFeature(log));
    }
}