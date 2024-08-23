FROM openjdk:21-jdk-slim-buster

WORKDIR /app

COPY target/MyCurrencyExchangeWebApp-0.0.1-SNAPSHOT.jar app/currency.jar

ENTRYPOINT ["java","-jar","app/currency.jar"]
