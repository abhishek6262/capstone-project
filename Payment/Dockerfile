ARG PORT=8080
ARG SERVICE_PATH=Payment

# Build stage
FROM maven:3.9.6-eclipse-temurin-17 AS builder

# Set working directory
WORKDIR /build

# Copy parent pom.xml first
COPY ../pom.xml .

# Create module directory and copy its pom.xml
RUN mkdir -p Payment
COPY pom.xml ./Payment/

# Copy source code
COPY src/ ./Payment/src/

# Download dependencies only
RUN mvn -B dependency:go-offline -pl Payment

# Package the application
RUN mvn -B clean package -DskipTests -pl Payment

# Runtime stage
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Copy jar from builder stage
COPY --from=builder /build/Payment/target/*.jar app.jar

EXPOSE ${PORT}

ENTRYPOINT ["java", "-jar", "app.jar"]