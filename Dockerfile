# Use a base image with OpenJDK 17
FROM eclipse-temurin:17

# Set the working directory
WORKDIR /app

# Copy the application JAR file
COPY target/coffee-order-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
