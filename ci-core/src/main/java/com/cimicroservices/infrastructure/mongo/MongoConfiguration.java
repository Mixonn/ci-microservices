package com.cimicroservices.infrastructure.mongo;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class MongoConfiguration {

//  @Value("spring.data.mongodb.host")
//  private String host;
//
//  @Value("spring.data.mongodb.port")
//  private int port;

//  @Bean
//  public MongoClient reactiveMongoClient() {
//    return MongoClients.create("mongodb://user:password@mongo:27017");
//  }
}
