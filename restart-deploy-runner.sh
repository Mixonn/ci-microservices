#!/bin/sh
gradle :deploy-runner:clean :deploy-runner:build
docker-compose up -d --build --no-deps deploy-runner
docker-compose logs -f deploy-runner
