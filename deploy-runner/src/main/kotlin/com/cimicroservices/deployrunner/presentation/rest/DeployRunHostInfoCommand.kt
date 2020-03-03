package com.cimicroservices.deployrunner.presentation.rest

class DeployRunHostInfoCommand {
    var host: String? = null
    var port: Int? = null

    override fun toString(): String {
        return "DeployRunHostInfoCommand(host=$host, port=$port)"
    }
}
