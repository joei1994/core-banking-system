# Use a lightweight base image
FROM openjdk:17-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy the JAR file into the container
COPY target/*.jar app.jar

# Expose port (optional, just for clarity)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
