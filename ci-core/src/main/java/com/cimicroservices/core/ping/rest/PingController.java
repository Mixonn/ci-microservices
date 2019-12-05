package com.cimicroservices.core.ping.rest;

import com.cimicroservices.core.ping.config.RestProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PingController {
  private final RestProperties restProperties;

  @GetMapping
  public String ping() {
    return restProperties.getProp();
  }
}
