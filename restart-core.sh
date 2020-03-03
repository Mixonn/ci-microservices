#!/bin/sh
gradle clean build
docker-compose up -d --build --no-deps ci-core
docker-compose logs -f ci-core
