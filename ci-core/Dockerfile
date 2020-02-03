FROM openjdk:11
LABEL maintainer="Osipiuk Bartosz <osipiuk.bartosz@gmail.com>"
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY ./build/libs/ci-core-0.0.1-SNAPSHOT.jar ./ci-core.jar
CMD ["java", "-jar", "/usr/app/ci-core.jar"]
