package com.cimicroservices.core.ping;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PingRepository extends ReactiveMongoRepository<Ping, String> {
}
