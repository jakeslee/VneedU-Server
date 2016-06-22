# jakes/vneedu-pack-producer
FROM jakes/java8-jdk
MAINTAINER Jakes Lee <jakeslee66@gmail.com>

ENV TOMCAT_WEBAPPS /usr/local/tomcat/webapps

COPY . /app/scripts/
WORKDIR /app

RUN yum install -y git unzip \
    && git clone https://github.com/jakeslee/VneedU-Server.git

VOLUME ["$TOMCAT_WEBAPPS", "/app"]

CMD /app/scripts/build-project.sh
