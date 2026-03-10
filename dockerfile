FROM openjdk:17-jdk-slim

# Set a working directory inside the container
WORKDIR /app

# Copy the JAR file from your local machine to the container
COPY app.jar /app/app.jar

# Expose the application port (optional, if your app listens on a port)
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java"]

