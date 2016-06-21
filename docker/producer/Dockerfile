# jakes/vneedu-pack-producer
FROM jakes/java8-jdk
MAINTAINER Jakes Lee <jakeslee66@gmail.com>

ENV TOMCAT_WEBAPPS /usr/local/tomcat/webapps

RUN yum install -y git unzip
RUN mkdir -p /app "$TOMCAT_WEBAPPS"
WORKDIR /app

RUN git clone https://github.com/jakeslee/VneedU-Server.git \
	&& cd VneedU-Server \
	&& VERSION=$(cat build.gradle | awk '$1 ~ /version/{print $2}' | sed -e "s/^'//" -e "s/'$//") \
	&& ./gradlew :vneedu-service:assembleDist \
	&& ./gradlew :vneedu-server:war \
	&& unzip ./service/build/distributions/vneedu-service-$VERSION".zip" -d /app/source \
	&& mv -Tf /app/source/vneedu-service-$VERSION /app/provider \
	&& cp ./server/build/libs/vneedu-server-$VERSION".war" $TOMCAT_WEBAPPS

VOLUME $TOMCAT_WEBAPPS
VOLUME /app
