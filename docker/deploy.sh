#!/bin/bash

set -a

if [[ "$1" = "provider" ]]; then
    echo "Deploying Provider"
    PROVIDER_HOST=`hostname -I | awk '{print $1}'`
    docker-compose up --build
fi


