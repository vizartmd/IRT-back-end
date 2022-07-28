FROM openjdk:8-jre-alpine
COPY target/irt-back-end-0.0.1-SNAPSHOT.jar irt-back-end
EXPOSE 8080
RUN apk --no-cache add curl
CMD ["java","-jar","irt-back-end"]
