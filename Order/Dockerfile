# Stage 1: Build
FROM capstone-base AS build

WORKDIR /build

ENV MODULE=Order

COPY ${MODULE}/src ./${MODULE}/src

# Build the Order module
RUN mvn -pl ${MODULE} clean package -DskipTests

# Stage 2: Runtime
FROM openjdk:17-jdk-slim

WORKDIR /app

ENV MODULE=Order

# Copy the generated artifact
COPY --from=build /build/${MODULE}/target/${MODULE}-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]