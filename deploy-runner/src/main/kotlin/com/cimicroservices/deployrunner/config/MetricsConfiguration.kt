package com.cimicroservices.deployrunner.config

import io.micrometer.core.aop.TimedAspect
import io.micrometer.core.instrument.MeterRegistry
import java.util.Optional
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.Profile
import org.springframework.scheduling.annotation.EnableScheduling

@Configuration
@EnableScheduling
@Profile("metrics")
open class MetricsConfiguration {
    @Bean
    open fun basePrefix(): MeterRegistryCustomizer<MeterRegistry> {
        return MeterRegistryCustomizer { registry: MeterRegistry ->
            registry
                    .config()
                    .commonTags(
                            "application",
                            "deployRunner",
                            "cloud",
                            Optional.ofNullable(System.getenv("CLOUD_NAME")).orElse("unknown"))
        }
    }

    @Bean
    @Primary
    open fun customizedMeterRegistry(meterRegistry: MeterRegistry): MeterRegistry {
        basePrefix().customize(meterRegistry)
        return meterRegistry
    }

    @Bean
    open fun timedAspect(customizedMeterRegistry: MeterRegistry): TimedAspect {
        return TimedAspect(customizedMeterRegistry)
    }
}
