#!/bin/bash

echo "Starting Node App..."
RUN npm run build 

# If JVM exits, keep the container alive for debugging
echo "App exited. Container will stay alive for debugging."
tail -f /dev/null
