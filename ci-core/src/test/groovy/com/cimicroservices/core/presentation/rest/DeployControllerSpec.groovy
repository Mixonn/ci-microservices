package com.cimicroservices.core.presentation.rest

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerPort;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.reactive.function.BodyInserters
import spock.lang.Specification;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
//@AutoConfigureMockMvc
//@AutoConfigureJsonTesters
//@WebFluxTest(DeployController.class)
@AutoConfigureStubRunner(
        stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = "com.cimicroservices:deploy-runner")
@DirtiesContext
class DeployControllerSpec extends Specification{

    @StubRunnerPort("deploy-runner") int producerPort;

    @Test
    def "given_WhenPassEvenNumberInQueryParam_ThenReturnEven"()
            throws Exception {
        given:
        def request = WebTestClient.bindToServer()
                .build()
                .post()
                .uri("http://localhost:" + this.producerPort + "/run/1")
                .bodyValue(DeployRunHostInfoCommand.builder().host("192.168.0.1").port(1231).build())
                .header("Content-Type", "application/json")
        when:
        def response = request.exchange()
        then:
        response.expectStatus().is2xxSuccessful()
                .expectBody(String.class)
                .value(Matchers.matchesRegex(".+"));

    }
}
