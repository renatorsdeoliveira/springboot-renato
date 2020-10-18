FROM openjdk:8-jdk-alpine
VOLUME /tmp
VOLUME /log
ADD target/*.jar app.jar

RUN apk add --update openssh

ENTRYPOINT exec java \
 -Djava.security.egd=file:/dev/./urandom \
 -Duser.timezone=Brazil/East \
 -Dspring.profiles.active=$SPRING_PROFILES_ACTIVE \
 -jar app.jar --trace
