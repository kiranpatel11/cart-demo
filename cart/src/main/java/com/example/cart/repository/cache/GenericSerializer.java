package com.example.cart.repository.cache;

import java.io.IOException;

import com.example.cart.config.ObjectMapperFactory;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.StreamSerializer;
import com.hazelcast.util.ExceptionUtil;

class GenericSerializer implements StreamSerializer<Object> {

	@Override
	public void destroy() {
		
	}

	@Override
	public int getTypeId() {
		return 1;
	}

	@Override
	public Object read(ObjectDataInput in) throws IOException {
       String clazz = in.readUTF();
        try {
            return ObjectMapperFactory.objectMapper().readValue(in.readByteArray(), Class.forName(clazz));
        } catch (ClassNotFoundException e) {
            throw ExceptionUtil.peel(e);
        }
	}

	@Override
	public void write(ObjectDataOutput out, Object object) throws IOException {
        out.writeUTF(object.getClass().getName());
        out.writeByteArray(ObjectMapperFactory.objectMapper().writeValueAsBytes(object));		
	}
}
