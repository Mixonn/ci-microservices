package com.cimicroservices.core.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableWebFlux
@EnableDiscoveryClient
@EnableConfigurationProperties
public class CiCoreConfiguration {

  @Bean
  @LoadBalanced
  public WebClient.Builder loadBalancedWebClientBuilder() {
    return WebClient.builder();
  }

  @Bean
  @RefreshScope
  public TrueService trueService(ConfProps confProps) {
    return new TrueService(confProps.getText());
  }

  @Bean
  public WrapperService wrapperService(TrueService trueService) {
    return new WrapperService(trueService);
  }
}
