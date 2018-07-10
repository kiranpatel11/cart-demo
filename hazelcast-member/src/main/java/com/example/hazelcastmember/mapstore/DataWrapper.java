package com.example.hazelcastmember.mapstore;

/**
 * DataWrapper wraps clazz name and byte[] value to be stored in hazelcast 
 * 
 * @author kp7466
 *
 */
public class DataWrapper {
	
    private String clazz;
    private byte[] data;
	
    public DataWrapper(String clazz, byte[] data) {
		super();
		this.clazz = clazz;
		this.data = data;
	}
    
	public String getClazz() {
		return clazz;
	}
	
	public byte[] getData() {
		return data;
	}
	  
}
