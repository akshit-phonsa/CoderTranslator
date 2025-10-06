# Multi-stage build for Spring Boot backend

# Stage 1: Build
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Expose port
EXPOSE 8080

# Set environment variables (override at runtime)
ENV OPENAI_API_KEY=""
ENV PERPLEXITY_API_KEY=""

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
