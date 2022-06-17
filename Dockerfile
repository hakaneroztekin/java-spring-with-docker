# use openjdk as a base image
FROM openjdk:16

# create a new directory named app
RUN mkdir app

# copy jar from the Build stage to container directory (/app)
COPY target/spring-app.jar /app

# make app the default directory for the upcoming commands
WORKDIR /app

# expose port 8080
EXPOSE 8080

# when container boots up, execute: java -jar spring-app.jar
ENTRYPOINT ["java", "-jar", "spring-app.jar"]