FROM node:22

WORKDIR /app

COPY . .

RUN npm install
RUN npm run build  # or skip this if running dev

EXPOSE 5173
CMD ["npm", "run", "dev", "--", "--host"]
COPY startup.sh /app/startup.sh
RUN chmod +x /app/startup.sh

ENTRYPOINT ["/app/startup.sh"]