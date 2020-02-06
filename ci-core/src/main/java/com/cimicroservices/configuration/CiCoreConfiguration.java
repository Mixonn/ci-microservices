package com.cimicroservices.configuration;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;

@Configuration
@EnableWebFlux
@EnableDiscoveryClient
public class CiCoreConfiguration {

  @Bean
  public MongoClient reactiveMongoClient() {
    return MongoClients.create("mongodb://user:password@mongo:27017");
  }
}
