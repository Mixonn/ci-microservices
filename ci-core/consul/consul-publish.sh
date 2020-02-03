#!/usr/bin/env bash

curl -X PUT http://127.0.0.1:8500/v1/kv/apps/cimcroservices/ci-core/config -v --data-binary @ci-core/consul/config.yml

