package com.cimicroservices.core.ping;

import com.cimicroservices.core.ping.config.RestProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class PingController {
  private final RestProperties restProperties;
  private final PingRepository pingRepository;

  @GetMapping
  public Flux<Ping> ping() {
      var currentMessage = restProperties.getProp();
      pingRepository.save(Ping.builder()
          .currentValueFromConfig(currentMessage)
          .build());
      return pingRepository.findAll();
  }
}
