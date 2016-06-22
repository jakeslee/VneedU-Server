#!/bin/bash

set -e
pwd
cd /app/VneedU-Server

function UPDATE_CODE() {
	git stash &&\
	git pull
}

UPDATE_CODE
VERSION=$(cat build.gradle | awk '$1 ~ /version/{print $2}' | sed -e "s/^'//" -e "s/'$//")

gradle :vneedu-service:assembleDist :vneedu-server:war \
&& unzip -o ./service/build/distributions/vneedu-service-$VERSION".zip" -d /app/source \
&& ls /app/source \
&& rsync -a --delete /app/source/vneedu-service-$VERSION/ /app/provider \
&& cp -f ./server/build/libs/vneedu-server-$VERSION".war" $TOMCAT_WEBAPPS

cat /etc/hosts | sed "s/.*$(hostname)/${PROVIDER_HOST} $(hostname)/" > /etc/hosts

exec "$@"
