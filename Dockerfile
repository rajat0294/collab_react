  # Use an official Gradle image as a build environment
FROM gradle:latest AS build
  
  # Set the working directory inside the container
WORKDIR /app
  
  # Copy the Gradle build files
COPY build.gradle settings.gradle /app/
COPY gradle /app/gradle
  
  # Copy the application source code
COPY src /app/src
  
  # Build the application
RUN gradle build --no-daemon
  
# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-oracle
  
  # Set the working directory inside the container
WORKDIR /app
  
  # Copy the built JAR file from the build stage
COPY --from=build /app/build/libs/core-spring-security-0.0.1-SNAPSHOT.jar app.jar
  
  # Expose the port that your Spring Boot app runs on
EXPOSE 8080

  # Define the command to run your Spring Boot application
CMD ["java", "-jar", "app.jar"]

