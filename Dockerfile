### BUILD ###
# use maven as base image
FROM maven:3.8.3-openjdk-16 AS build

# copy code to container directory (/home/app/src)
COPY /src /home/app/src

# copy pom to container directory (/home/app)
COPY pom.xml /home/app

# generate jar file
RUN mvn -f home/app/pom.xml clean package

# -------------------------------------------- #

### PACKAGE ###
# use openjdk as a base image
FROM openjdk:16

# create a new directory named app
RUN mkdir app

# copy jar from the Build stage to container directory (/app)
COPY --from=build /home/app/target/spring-app.jar /app

# make app the default directory for the upcoming commands
WORKDIR /app

# expose port 8080
EXPOSE 8080

# when container boots up, execute: java -jar spring-app.jar
ENTRYPOINT ["java", "-jar", "spring-app.jar"]