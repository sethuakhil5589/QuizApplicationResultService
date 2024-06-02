FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/QuizApplicationResultService-0.0.1-SNAPSHOT.jar QuizApplicationResultService.jar
ENTRYPOINT ["java","-jar","/QuizApplicationResultService.jar"]
EXPOSE 8084
