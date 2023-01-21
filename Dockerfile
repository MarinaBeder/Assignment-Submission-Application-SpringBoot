#
# Build stage
#
FROM maven:3.8.2-jdk-11 AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
#ARG war_FILE=/home/app/*.war
#COPY . .
#ENTRYPOINT ["java","-jar","AssignmentSubmission.war"]
FROM maven:3.6.0-jdk-11-slim 
ARG JAR_FILE
COPY . .
ENTRYPOINT ["java","-jar","src.jar"]
