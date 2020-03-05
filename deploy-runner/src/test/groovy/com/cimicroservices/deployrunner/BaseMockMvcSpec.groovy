package com.cimicroservices.deployrunner

import com.cimicroservices.deployrunner.presentation.rest.DeployRunnerController
import io.restassured.module.mockmvc.RestAssuredMockMvc
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@DirtiesContext
@AutoConfigureMessageVerifier
class BaseMockMvcSpec extends Specification {

    @Autowired
    private DeployRunnerController deployRunnerController

    def setup() {
        StandaloneMockMvcBuilder standaloneMockMvcBuilder = MockMvcBuilders.standaloneSetup(deployRunnerController)
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder)
    }
}
