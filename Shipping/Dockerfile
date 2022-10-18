FROM openjdk:17-ea-jdk

COPY ./build/libs/Shipping-0.0.1-SNAPSHOT.jar /app.jar

EXPOSE 5505

ENTRYPOINT ["java", "-jar", "/app.jar"]