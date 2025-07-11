FROM openjdk:21-jdk-slim

# Optional: install bash & net tools
RUN apt-get update && \
    apt-get install -y bash procps iproute2 && \
    rm -rf /var/lib/apt/lists/*


# Working directory
WORKDIR /opt/springboot

# Create folder for keystore
WORKDIR /opt/springboot/protected

# Copy keystore file from local folder
COPY protected/localroots.p12 /opt/springboot/protected/localroots.p12

# Back to root working dir
WORKDIR /opt/springboot

# Copy built JAR from local target folder
COPY target/localroots-backend-0.0.1-SNAPSHOT.jar localroots-backend-0.0.1-SNAPSHOT.jar


COPY config/application.properties config/application.properties
# Expose HTTPS port
EXPOSE 8443

# Just keep container running
CMD ["tail", "-f", "/dev/null"]
