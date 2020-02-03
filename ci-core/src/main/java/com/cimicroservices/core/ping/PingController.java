package com.cimicroservices.core.ping;

import com.cimicroservices.core.ping.config.RestProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class PingController {
  private final RestProperties restProperties;

  @GetMapping
  public Mono<String> ping() {
    return Mono.just(restProperties.getProp());
  }
}
