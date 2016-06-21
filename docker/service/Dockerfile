# jakes/vneedu-provider
FROM jakes:java8-jdk
MAINTAINER Jakes Lee <jakeslee66@gmail.com>

VOLUME /app/conf
WORKDIR /app/conf
COPY . /app/conf

CMD ["/app/provider/bin/vneedu-service"]
