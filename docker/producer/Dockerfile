# jakes/vneedu-pack-producer
FROM jakes/java8-jdk
MAINTAINER Jakes Lee <jakeslee66@gmail.com>

ENV TOMCAT_WEBAPPS /usr/local/tomcat/webapps

RUN yum install -y git unzip
RUN mkdir -p /app "$TOMCAT_WEBAPPS"

COPY build-project.sh /app
WORKDIR /app

RUN git clone https://github.com/jakeslee/VneedU-Server.git

VOLUME $TOMCAT_WEBAPPS
VOLUME /app

CMD ["/app/build-project.sh"]
