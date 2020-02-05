package com.cimicroservices.core;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@ConfigurationProperties("ping.rest")
@Validated
@Data
public class RestProperties {
  private String prop;
}
