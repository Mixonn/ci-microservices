package com.cimicroservices.core.presentation.rest

import com.cimicroservices.core.core.code.deploy.DeployRunService
import org.hamcrest.Matchers
import org.junit.jupiter.api.extension.ExtendWith
import org.spockframework.spring.SpringSpy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient
import spock.lang.Specification

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureWebTestClient
@AutoConfigureJsonTesters
@AutoConfigureStubRunner(
        stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = "com.cimicroservices:deploy-runner")
@DirtiesContext
class DeployControllerSpecIT extends Specification{

    @Autowired private WebTestClient webTestClient

    @SpringSpy private DeployRunService deployRunService

    def "Should call external service to run deploy" () {
        given: "request to run deploy with dummy data"
        String dumbHost = "192.168.0.1"
        int dumbPort = 1234
        def request = webTestClient.post().uri("/deploy/1/run")
                .bodyValue(DeployRunHostInfoCommand.builder().host(dumbHost).port(dumbPort).build())
                .header("Content-Type", "application/json")
        when: "exchange request"
        def response = request.exchange()
        then: "expect status is ok"
        response.expectStatus().is2xxSuccessful()
                .expectBody(String.class)
                .value(Matchers.matchesRegex(".+"));
        and: "should call external service"
        1 * deployRunService.runDeploy(_, _, _)
    }
}
