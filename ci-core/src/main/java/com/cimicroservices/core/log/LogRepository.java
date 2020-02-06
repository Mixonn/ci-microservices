package com.cimicroservices.core.log;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

interface LogRepository extends ReactiveMongoRepository<Log, String> {
  Flux<Log> findAllByUsername(String username);
}
