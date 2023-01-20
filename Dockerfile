#
# Build stage
#
FROM maven:3.8.2-jdk-11 AS build
COPY . .
#RUN mvn clean package com.coderscampus

#
# Package stage
#
FROM openjdk:11-jdk-slim
#COPY --from=build /target/AssignmentSubmission-0.0.1-SNAPSHOT.jar AssignmentSubmission.jar
ENV PORT=8080
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","AssignmentSubmission.jar"]

# cat Dockerfile
FROM mysql:latest

MAINTAINER baeldung.com

RUN chown -R mysql:root /var/lib/mysql/

ARG MYSQL_DATABASE
ARG MYSQL_USER
ARG MYSQL_PASSWORD
ARG MYSQL_ROOT_PASSWORD

ENV MYSQL_DATABASE=railway
ENV MYSQL_USER=root
ENV MYSQL_PASSWORD=PVgvKakrfvPbguT1i7qU
ENV MYSQL_ROOT_PASSWORD=PVgvKakrfvPbguT1i7qU

#ADD data.sql /etc/mysql/data.sql

#RUN sed -i 's/MYSQL_DATABASE/'$MYSQL_DATABASE'/g' /etc/mysql/data.sql
#RUN cp /etc/mysql/data.sql /docker-entrypoint-initdb.d

EXPOSE 8080
