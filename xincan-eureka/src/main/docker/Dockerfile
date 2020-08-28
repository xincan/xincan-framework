# FROM java:8
# VOLUME /tmp
# ADD xincan-eureka-0.0.1-SNAPSHOT.jar eureka.jar
# EXPOSE 8761
# ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/eureka.jar"]

FROM java:8
ARG JAR_FILE
ENV PROFILE default
ENV JAVA_OPTS -server
ADD ${JAR_FILE} eureka.jar
EXPOSE 8761
ENTRYPOINT java -Dspring.profiles.active=${PROFILE} -Duser.timezone=Asia/Shanghai ${JAVA_OPTS} -jar eureka.jar
