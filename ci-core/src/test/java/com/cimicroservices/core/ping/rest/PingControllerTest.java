package com.cimicroservices.core.ping.rest;

import com.cimicroservices.core.ping.PingController;
import com.cimicroservices.core.ping.config.RestProperties;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.ExceptionHandler;
import reactor.blockhound.BlockHound;
import reactor.core.publisher.Mono;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class PingControllerTest {

  @BeforeEach
  void setUp() {
  }

  @BeforeAll
  static void setupBeforeAll() {
    BlockHound.install();
  }

  @Test
  void checkBlockHound() {
    assertThrows(Throwable.class, () -> {
      Mono.delay(Duration.ofMillis(1))
          .doOnNext(it -> {
            try {
              Thread.sleep(10);
            } catch (InterruptedException e) {
              throw new RuntimeException(e);
            }
          })
          .block();
    });
  }

//  @Test
//  void shouldBeNotBlocking() {
//    RestProperties restProperties = new RestProperties();
//    restProperties.setProp("test");
//    PingController pingController = new PingController(restProperties);
//
//    pingController.ping().block();
//  }
}
