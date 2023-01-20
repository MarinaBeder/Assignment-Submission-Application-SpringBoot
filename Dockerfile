#
# Build stage
#
FROM maven:3.8.2-jdk-11 AS build
COPY . .
RUN mvn clean package -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

#
# Package stage
#
FROM openjdk:11-jdk-slim
COPY --from=build /target/dependency AssignmentSubmissionApplication
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-cp","com.coderscampus.AssignmentSubmissionApplication"]
