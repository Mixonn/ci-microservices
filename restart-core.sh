#!/bin/sh
if ! gradle :ci-core:clean :ci-core:build; then
    echo "Build failed"
    exit 1
fi
docker-compose up -d --build --no-deps ci-core
docker-compose logs -f ci-core
