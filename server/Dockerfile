#
# Build stage
#
FROM maven:3-openjdk-18-slim AS build
WORKDIR /home/app/
COPY src src
COPY pom.xml .
RUN mvn -f pom.xml clean package -DskipTests

#
# Package stage
#
FROM openjdk:18-jdk-slim-buster
COPY --from=build /home/app/target/jfs-lab-salt-stars-1.0-SNAPSHOT.jar /home/usr/local/lib/salt-stars.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/home/usr/local/lib/salt-stars.jar"]