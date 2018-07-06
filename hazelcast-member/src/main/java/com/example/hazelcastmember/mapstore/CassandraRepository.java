package com.example.hazelcastmember.mapstore;

import org.springframework.data.repository.CrudRepository;

public interface CassandraRepository extends CrudRepository<PersistenceEntity, String>{

}