FROM openjdk:8-jdk-alpine
MAINTAINER xincan
VOLUME /tmp
ADD xincan-user-0.0.1-SNAPSHOT.jar xincan-user.jar
EXPOSE 8000
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar", "/xincan-user.jar"]
