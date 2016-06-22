#!/bin/bash

set -a

REGISTRY_ADDR=10.5.0.254:2181

if [[ "$1" = "provider" ]]; then
    echo "Deploying Provider" \
    && PROVIDER_HOST=`hostname -I | awk '{print $1}'` \
    && docker-compose build \
    && docker-compose run provider
fi
