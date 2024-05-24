FROM openjdk:17-jdk

LABEL authors="Majkel"

COPY ms-games/target/ms-games-1.0.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]