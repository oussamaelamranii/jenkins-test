# Use the official Maven image as a base
FROM maven:3.9.0 AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project files to the container
COPY . .

# Install the Maven-built Java application into the local Maven repository
RUN mvn package

# Stage 2: Use a smaller base image for runtime
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built Java application from the previous stage
COPY --from=builder /app/target/*.jar /app/app.jar

# Run the Java application
CMD ["sh", "-c", "java -jar target/*.jar"]
