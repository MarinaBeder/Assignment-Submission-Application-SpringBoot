#
# Build stage
#
##FROM maven:3.8.2-jdk-11 AS build
##COPY . .
##RUN mvn clean package -DskipTests
#RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

#
# Package stage
#
##FROM openjdk:11-jdk-slim
##COPY --from=build /target/dependency AssignmentSubmissionApplication
# ENV PORT=8080
##EXPOSE 8080
##ENTRYPOINT ["java","-cp","com.coderscampus.AssignmentSubmissionApplication"]
#### Stage 1: Build the application
FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","AssignmentSubmission"]
COPY src src

# Package the application
###RUN mvnw package
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)


#### Stage 2: A minimal docker image with command to run the app 
FROM adoptopenjdk/openjdk11:ubi

ARG DEPENDENCY=/app/target/dependency

# Copy project dependencies from the build stage
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
 
ENTRYPOINT ["java","-cp","app:app/lib/*","com.coderscampus.AssignmentSubmissionApplication"]
#################################################################################
#FROM openjdk:8
#ADD target/com.coderscampus.AssignmentSubmission com.coderscampus.AssignmentSubmission
#EXPOSE 8080
#ENTRYPOINT ["java", "-cp", "com.coderscampus.AssignmentSubmission"]


