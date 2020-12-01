FROM openjdk:8-jdk-alpine
EXPOSE 9091
ARG DEPENDENCY=target/healthcare-user-docker.jar
COPY ${DEPENDENCY} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]