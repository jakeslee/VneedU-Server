#!/bin/bash

set -e
cd VneedU-Server

function UPDATE_CODE() {
	git stash &&\
	git pull
}

UPDATE_CODE
VERSION=$(cat build.gradle | awk '$1 ~ /version/{print $2}' | sed -e "s/^'//" -e "s/'$//") \

&& ./gradlew :vneedu-service:assembleDist \
&& ./gradlew :vneedu-server:war \
&& unzip ./service/build/distributions/vneedu-service-$VERSION".zip" -d /app/source \
&& mv -Tf /app/source/vneedu-service-$VERSION /app/provider \
&& cp ./server/build/libs/vneedu-server-$VERSION".war" $TOMCAT_WEBAPPS
