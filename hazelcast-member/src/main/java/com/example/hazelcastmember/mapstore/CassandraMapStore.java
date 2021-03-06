package com.example.hazelcastmember.mapstore;

import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.MapLoaderLifecycleSupport;
import com.hazelcast.core.MapStore;

@Component
class CassandraMapStore implements MapStore<String, DataWrapper>, MapLoaderLifecycleSupport{
	
	private CassandraRepository cassandraRepository;
	
	private String mapName;
	
	@Autowired
	private CassandraMapStore(CassandraRepository repo) {
		this.cassandraRepository = repo;
	}
	
	@Override
	public DataWrapper load(String key) {
		System.out.println("load " + key);
		return cassandraRepository.findById(formKey(key))
					.map(v -> new DataWrapper(v.getClazz(), v.getValue().array()))
					.orElse(null);
	}

	@Override
	public Map<String, DataWrapper> loadAll(Collection<String> arg0) {
		return null;
	}

	@Override
	public Iterable<String> loadAllKeys() {
		return null;
	}

	@Override
	public void delete(String key) {
		cassandraRepository.deleteById(key);
	}

	@Override
	public void deleteAll(Collection<String> keys) {
		
	}

	@Override
	public void store(String key, DataWrapper value) {
		System.out.println("store " + key);
		cassandraRepository.save(new PersistenceEntity(formKey(key), value.getClazz(), ByteBuffer.wrap(value.getData())));
	}

	@Override
	public void storeAll(Map<String, DataWrapper> arg0) {
		
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void init(HazelcastInstance instance, Properties props, String mapName) {
		this.mapName = mapName;
	}
	
	private String formKey(String key) {
		return this.mapName + ":" + key;
	}

}
