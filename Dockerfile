# define base docker image
FROM openjdk:8
LABEL maintainer="docker_test"
ADD target/irt-back-end-0.0.1-SNAPSHOT.war irt-back-end.war
ENTRYPOINT ["java", "-jar", "irt-back-end.war"]
