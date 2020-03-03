package com.cimicroservices.deployrunner

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class DeployRunnerApplication

fun main(args: Array<String>) {
    runApplication<DeployRunnerApplication>(*args)
}
