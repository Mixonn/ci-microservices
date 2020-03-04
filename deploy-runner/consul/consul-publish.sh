#!/usr/bin/env bash

curl -X PUT http://127.0.0.1:8500/v1/kv/apps/cimcroservices/app-deploy-runner/config -v --data-binary @deploy-runner/consul/config.yml

