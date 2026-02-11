# =========================================
# DOCKERFILE - API HORARIO MED
# Multi-stage build para Render
# =========================================

# STAGE 1: BUILD
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml ./
COPY .mvn .mvn
COPY mvnw mvnw
RUN chmod +x mvnw
COPY src ./src

RUN ./mvnw clean package -DskipTests

# STAGE 2: RUNTIME
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

COPY --from=build /app/target/apihorariomed-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENV SPRING_PROFILES_ACTIVE=prod

ENTRYPOINT ["java", "-jar", "app.jar"]
