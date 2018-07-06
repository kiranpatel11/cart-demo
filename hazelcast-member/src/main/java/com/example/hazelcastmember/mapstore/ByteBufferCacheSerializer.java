package com.example.hazelcastmember.mapstore;

import java.io.IOException;
import java.nio.ByteBuffer;

import org.springframework.stereotype.Component;

import com.hazelcast.nio.serialization.ByteArraySerializer;

public class ByteBufferCacheSerializer implements ByteArraySerializer<ByteBuffer>{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub		
	}

	@Override
	public int getTypeId() {
		return 1;
	}

	@Override
	public ByteBuffer read(byte[] bytes) throws IOException {
		return ByteBuffer.wrap(bytes);
	}

	@Override
	public byte[] write(ByteBuffer byteBuffer) throws IOException {
		return byteBuffer.array();
	}	

}
