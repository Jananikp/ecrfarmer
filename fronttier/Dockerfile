FROM node:22-slim AS builder


WORKDIR /app

COPY package*.json ./
RUN npm ci

COPY . .
RUN npm run build

# Output artifact only
# You don't even need a final stage — just copy /app/dist/ to your host
