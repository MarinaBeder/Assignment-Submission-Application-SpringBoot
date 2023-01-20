#### Stage 1: Build the application
FROM adoptopenjdk/openjdk11:ubi as build
#
# Build stage
#
FROM maven:3.8.2-jdk-11 AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:11-jdk-slim
COPY --from=build /target/com.coderscampus.AssignmentSubmissionApplication-0.0.1-SNAPSHOT com.coderscampus.AssignmentSubmissionApplication
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-cp","com.coderscampus.AssignmentSubmissionApplication"]
# Set the current working directory inside the image
#WORKDIR /app

# Copy maven executable to the image
#COPY mvnw .
#COPY .mvn .mvn

# Copy the pom.xml file
#COPY pom.xml .

# Build all the dependencies in preparation to go offline. 
# This is a separate step so the dependencies will be cached unless 
# the pom.xml file has changed.
#RUN ./mvnw dependency:go-offline -B

# Copy the project source
#COPY src src

# Package the application
#RUN ./mvnw package
#RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)


#### Stage 2: A minimal docker image with command to run the app 
#FROM adoptopenjdk/openjdk11:ubi

#ARG DEPENDENCY=/app/target/dependency

# Copy project dependencies from the build stage
#COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
#COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
 
#ENTRYPOINT ["java","-cp","app:app/lib/*","com.coderscampus.AssignmentSubmissionApplication"]
