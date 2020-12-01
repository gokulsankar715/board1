FROM openjdk:8-jdk-alpine
EXPOSE 9092
ARG DEPENDENCY=target/healthcare-patient-docker.jar
COPY ${DEPENDENCY} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]