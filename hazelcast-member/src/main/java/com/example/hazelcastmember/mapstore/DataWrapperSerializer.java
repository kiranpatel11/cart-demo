package com.example.hazelcastmember.mapstore;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.StreamSerializer;

@Component
class DataWrapperSerializer implements StreamSerializer<DataWrapper>{

	@Override
	public void destroy() {
	}

	@Override
	public int getTypeId() {
		return 1;
	}

	@Override
	public DataWrapper read(ObjectDataInput in) throws IOException {
		return new DataWrapper(in.readUTF(), in.readByteArray());
	}

	@Override
	public void write(ObjectDataOutput out, DataWrapper dataWrapper) throws IOException {
        out.writeUTF(dataWrapper.getClazz());
        out.writeByteArray(dataWrapper.getData());		
	}	
}
