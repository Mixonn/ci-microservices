package com.cimicroservices.core.presentation.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureWebTestClient
@AutoConfigureJsonTesters
@AutoConfigureStubRunner(
    stubsMode = StubRunnerProperties.StubsMode.LOCAL,
    ids = "com.cimicroservices:deploy-runner")
@DirtiesContext
public class BeerControllerTest {

  @Autowired
  WebTestClient webTestClient;

  @Autowired DeployController deployController;

  @Test
  public void should_give_me_a_beer_when_im_old_enough() throws Exception {
    webTestClient.post().uri("/deploy/1/run")
        .bodyValue(DeployRunHostInfoCommand.builder().host("192.168.0.1").port(1231).build())
        .header("Content-Type", "application/json").exchange()
        .expectStatus().isOk();
  }

}
