FROM openjdk:17-ea-jdk

COPY ./build/libs/CreditTransaction-0.0.1-SNAPSHOT.jar /app.jar

EXPOSE 5507

ENTRYPOINT ["java", "-jar", "/app.jar"]