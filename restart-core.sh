#!/bin/sh
gradle clean build
docker-compose up -d --build ci-core
docker-compose logs -f ci-core
