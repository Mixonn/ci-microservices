package com.cimicroservices.core.presentation.rest

import com.cimicroservices.CiCoreApplication
import com.cimicroservices.core.core.code.DeployFacade
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerPort
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Import
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.reactive.function.client.WebClient
import spock.lang.Ignore
import spock.lang.Specification

@ExtendWith(SpringExtension)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
//@AutoConfigureMockMvc
//@AutoConfigureJsonTesters
//@WebFluxTest(controllers = DeployController)
@WebFluxTest
@AutoConfigureStubRunner(
        stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = "com.cimicroservices:deploy-runner")
//@DirtiesContext
@ComponentScan("com.cimicroservices.*")
class DeployControllerNextSpec extends Specification{

    @Autowired private WebTestClient webTestClient;

    def "hehe" () {
        given:
        def request = webTestClient.post().uri("/deploy/1/run")
                .bodyValue(DeployRunHostInfoCommand.builder().host("192.168.0.1").port(1231).build())
                .header("Content-Type", "application/json")
        when:
        def response = request.exchange()
        then:
        response.expectStatus().is2xxSuccessful()
                .expectBody(String.class)
                .value(Matchers.matchesRegex(".+"));
    }


    @Ignore
    def "given_WhenPassEvenNumberInQueryParam_ThenReturnEven"()
            throws Exception {
        given:
        def request = WebTestClient.bindToServer()
                .build()
                .post()
                .uri("/deploy/1/run")
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
