#!/bin/sh
gradle clean build
docker-compose up -d consul
while ! curl -Ssf localhost:8500; do
    sleep 2
done
sleep 1
./ci-core/consul/consul-publish.sh
docker-compose up -d ci-core
