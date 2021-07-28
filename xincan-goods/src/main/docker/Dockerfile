FROM openjdk:8-jdk-alpine
MAINTAINER xincan
VOLUME /tmp
ADD xincan-goods-0.0.1-SNAPSHOT.jar xincan-goods.jar
EXPOSE 8000
ENTRYPOINT ["/bin/sh", "-c", "set -e && java -Djava.security.egd=file:/dev/./urandom -jar /xincan-goods.jar"]
