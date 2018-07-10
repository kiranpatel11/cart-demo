package com.example.hazelcastmember.mapstore;

import org.springframework.data.repository.CrudRepository;

interface CassandraRepository extends CrudRepository<PersistenceEntity, String>{

}