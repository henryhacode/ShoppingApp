FROM openjdk:17-ea-jdk

COPY ./build/libs/NotificationServices-0.0.1-SNAPSHOT.jar /app.jar

EXPOSE 5506

ENTRYPOINT ["java", "-jar", "/app.jar"]