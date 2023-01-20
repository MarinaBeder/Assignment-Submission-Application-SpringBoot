#
# Build stage
#
FROM maven:3.6.3-jdk-8-slim AS build
RUN mvn clean package -DskipTests
COPY src /home/app/src
COPY pom.xml /home/app

#
# Package stage
#
FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY --from=build /home/app/target/war_name.war app.war
ENTRYPOINT ["java","-jar","/app.war"]
