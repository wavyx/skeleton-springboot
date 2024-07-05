# Build stage
FROM gradle:8.8-jdk21 AS build
WORKDIR /app
COPY . .
RUN gradle build --no-daemon

# Base stage
FROM openjdk:21-slim AS base
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar

# Development stage
FROM base AS development
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "app.jar"]

# Production stage (default)
FROM base AS production
EXPOSE 9090
ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75", "-jar", "app.jar"]
