FROM openjdk:17-ea-jdk

COPY ./build/libs/BankTransaction-0.0.1-SNAPSHOT.jar /app.jar

EXPOSE 5509

ENTRYPOINT ["java", "-jar", "/app.jar"]