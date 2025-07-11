#!/bin/bash

# Start Spring Boot app with external config and HTTPS
echo "Starting Spring Boot application..."
nohup java -jar \
  --spring.config.location=file:/opt/springboot/config/application.properties \
  localroots-backend-0.0.1-SNAPSHOT.jar > app.log 2>&1 &

SPRING_PID=$!
echo $SPRING_PID > /tmp/springboot.pid

# Keep container alive
tail -f app.log