FROM java:8
VOLUME /tmp
ADD xincan-gateway-0.0.1-SNAPSHOT.jar xincan-gateway.jar
EXPOSE 8040
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/xincan-gateway.jar"]
