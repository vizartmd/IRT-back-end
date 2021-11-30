FROM openjdk:8-jdk-alpine
MAINTAINER stefanini.com
COPY target/irt-back-end-0.0.1-SNAPSHOT.jar irt-back-end.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","irt-back-end.jar"]