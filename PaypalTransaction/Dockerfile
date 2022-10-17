FROM openjdk:17-ea-jdk

COPY ./build/libs/PaypalTransaction-0.0.1-SNAPSHOT.jar /app.jar

EXPOSE 5508

ENTRYPOINT ["java", "-jar", "/app.jar"]