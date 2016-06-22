# jakes/vneedu-provider
FROM jakes/java8-jdk
MAINTAINER Jakes Lee <jakeslee66@gmail.com>

ENV GRADLE_VERSION 2.9

WORKDIR /usr/bin
RUN yum install -y git unzip
RUN curl -sLO https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-all.zip \
    && unzip gradle-${GRADLE_VERSION}-all.zip \
    && ln -s gradle-${GRADLE_VERSION} gradle \
    && rm gradle-${GRADLE_VERSION}-all.zip

ENV GRADLE_HOME /usr/bin/gradle
ENV PATH $PATH:$GRADLE_HOME/bin

COPY . /vneedu/conf
WORKDIR /vneedu/conf

EXPOSE 20808

ENTRYPOINT ["/app/scripts/build-project.sh"]

CMD ["/app/provider/bin/vneedu-service"]
