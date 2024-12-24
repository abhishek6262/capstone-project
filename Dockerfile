# Stage 1: Prepare Maven Dependencies
FROM maven:3.9.3-eclipse-temurin-17 AS base

WORKDIR /build

COPY pom.xml ./pom.xml

COPY Cart/pom.xml ./Cart/pom.xml
COPY Order/pom.xml ./Order/pom.xml
COPY Payment/pom.xml ./Payment/pom.xml
COPY Product/pom.xml ./Product/pom.xml
COPY User/pom.xml ./User/pom.xml

# Download all dependencies (but don't build modules)
RUN mvn dependency:go-offline