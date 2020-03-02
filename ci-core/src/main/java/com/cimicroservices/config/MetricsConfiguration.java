package com.cimicroservices.config;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import java.util.Optional;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@Profile("metrics")
public class MetricsConfiguration {

  @Bean
  public MeterRegistryCustomizer<MeterRegistry> basePrefix() {
    return registry ->
        registry
            .config()
            .commonTags(
                "application",
                "ciCore",
                "cloud",
                Optional.ofNullable(System.getenv("CLOUD_NAME")).orElse("unknown"));
  }

  @Bean
  @Primary
  public MeterRegistry customizedMeterRegistry(MeterRegistry meterRegistry) {
    basePrefix().customize(meterRegistry);
    return meterRegistry;
  }

  @Bean
  public TimedAspect timedAspect(MeterRegistry customizedMeterRegistry) {
    return new TimedAspect(customizedMeterRegistry);
  }
}
