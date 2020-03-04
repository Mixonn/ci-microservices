package com.cimicroservices.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties("ping")
@Component
public class ConfProps {
  private String text;
}
