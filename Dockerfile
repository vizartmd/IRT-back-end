#FROM anapsix/alpine-java
#FROM alpine:latest
#RUN apk add openjdk11

#MAINTAINER stefanini.com
#COPY target/irt-back-end-0.0.1-SNAPSHOT.jar /home/irt-back-end.jar
#EXPOSE 8080

#CMD ["java", "-jar","/home/irt-back-end.jar"]

FROM openjdk:8
COPY target/irt-back-end-0.0.1-SNAPSHOT-spring-boot.jar /irt-back-end.jar
EXPOSE 8080
CMD ["java","-jar","/irt-back-end.jar"]