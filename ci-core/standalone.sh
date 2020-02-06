#!/usr/bin/env bash

# WIP - later will be replaced by docker-compose or kubernates
docker run -d --name consul-1 -p 8500:8500 -e CONSUL_BIND_INTERFACE=eth0 consul
./consul-publish.sh
gradle clean build bootrun:run
