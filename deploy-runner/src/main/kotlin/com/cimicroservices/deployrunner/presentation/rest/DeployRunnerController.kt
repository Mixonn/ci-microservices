package com.cimicroservices.deployrunner.presentation.rest

import javax.validation.constraints.NotBlank
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

inline fun <reified T> T.logger(): Logger {
    if (T::class.isCompanion) {
        return LoggerFactory.getLogger(T::class.java.enclosingClass)
    }
    return LoggerFactory.getLogger(T::class.java)
}

@RestController
@Slf4j
class DeployRunnerController {

    private val logger = logger()

    @PostMapping("/run/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun runDeploy(
        @PathVariable @NotBlank id: String,
        @RequestBody deployRunHostInfoCommand: DeployRunHostInfoCommand
    ): Int {
        logger.info("Received deploy to run: $deployRunHostInfoCommand")
        return 252125
    }
}
