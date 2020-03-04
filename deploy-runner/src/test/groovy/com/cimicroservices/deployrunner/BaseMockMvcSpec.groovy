package com.cimicroservices.deployrunner

import com.cimicroservices.deployrunner.presentation.rest.DeployRunnerController
import spock.lang.Specification

abstract class BaseMockMvcSpec extends Specification {
    def setup() {
        RestAssuredMockMvc.standaloneSetup(new DeployRunnerController())
    }

    void isProperCorrelationId(Integer correlationId) {
        assert correlationId == 123456
    }

    void isEmpty(String value) {
        assert value == null
    }
}
