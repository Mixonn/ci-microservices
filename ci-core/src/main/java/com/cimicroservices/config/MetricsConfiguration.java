package com.cimicroservices.config;

import io.micrometer.core.instrument.MeterRegistry;
import java.util.Optional;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class MetricsConfiguration {

  @Bean
  public MeterRegistryCustomizer<MeterRegistry> basePrefix() {
    return registry ->
        registry
            .config()
            .commonTags(
                "application",
                "myCustomNameApp",
                "cloud",
                Optional.ofNullable(System.getenv("CLOUD_NAME")).orElse("unknown"));
  }

  @Bean
  @Primary
  public MeterRegistry customizedMeterRegistry(MeterRegistry meterRegistry) {
    basePrefix().customize(meterRegistry);
    return meterRegistry;
  }
}
