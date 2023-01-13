FROM openjdk:11
COPY build/libs/Project-2-0.0.1-SNAPSHOT.jar application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]