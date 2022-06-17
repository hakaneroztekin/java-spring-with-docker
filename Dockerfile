# use openjdk 11 image
FROM openjdk:11

# copy the jar from host to container
ADD target/spring-app.jar app/spring-app.jar

# make app default directory for the upcoming commands
WORKDIR /app

# expose port 8080
EXPOSE 8080

# when container starts execute: java -jar spring-app.jar
ENTRYPOINT ["java", "-jar", "spring-app.jar"]