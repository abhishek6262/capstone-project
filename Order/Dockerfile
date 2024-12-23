ARG PORT=8080
ARG SERVICE_PATH=Order

# Build stage
FROM maven:3.9.6-eclipse-temurin-17 AS builder

# Set working directory
WORKDIR /build

# Copy parent pom.xml first
COPY ../pom.xml .

# Create module directory and copy its pom.xml
RUN mkdir -p Order
COPY pom.xml ./Order/

# Copy source code
COPY src/ ./Order/src/

# Download dependencies only
RUN mvn -B dependency:go-offline -pl Order

# Package the application
RUN mvn -B clean package -DskipTests -pl Order

# Runtime stage
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Copy jar from builder stage
COPY --from=builder /build/Order/target/*.jar app.jar

EXPOSE ${PORT}

ENTRYPOINT ["java", "-jar", "app.jar"]