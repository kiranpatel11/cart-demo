package com.example.hazelcastmember.mapstore;

import java.nio.ByteBuffer;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("cache_persistence")
class PersistenceEntity {

	@PrimaryKey("key")
	private String key;
	
	/**
	 * FQCN to be used for deserialization of this.value.
	 */
	@Column("class_name")
	private String clazz;
	
	@Column("value")
	private ByteBuffer value;

	public PersistenceEntity(String key, String clazz, ByteBuffer value) {
		super();
		this.key = key;
		this.clazz = clazz;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}
	
	public String getClazz() {
		return clazz;
	}

	public ByteBuffer getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersistenceEntity other = (PersistenceEntity) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
	
}
