package com.cimicroservices.infrastructure.mongo;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class MongoConfiguration {
  @Bean
  public MongoClient reactiveMongoClient() {
    return MongoClients.create("mongodb://user:password@mongo:27017");
  }
}
