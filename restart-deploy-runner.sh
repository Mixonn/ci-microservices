#!/bin/sh
if ! gradle :deploy-runner:clean :deploy-runner:build; then
    echo "Build failed"
    exit 1
fi
docker-compose up -d --build --no-deps deploy-runner
docker-compose logs -f deploy-runner
