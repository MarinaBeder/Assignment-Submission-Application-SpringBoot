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
COPY --from=build /home/app/target/AssignmentSubmissionApplication.war AssignmentSubmissionApplication.war
ENTRYPOINT ["java","-jar","AssignmentSubmissionApplication.war"]
