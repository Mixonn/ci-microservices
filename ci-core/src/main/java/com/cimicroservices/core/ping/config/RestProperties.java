package com.cimicroservices.core.ping.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Configuration
@ConfigurationProperties("ping.rest")
@Validated
@Data
public class RestProperties {
  @NotNull private String prop;
}
