#!/bin/bash
apt-get update -y
apt-get upgrade -y

# Install Docker
apt-get install -y docker.io
systemctl enable docker
systemctl start docker
usermod -aG docker ubuntu

# Install OpenJDK 21
apt-get install -y openjdk-21-jdk

# Install Node.js 22
curl -fsSL https://deb.nodesource.com/setup_22.x | bash -
apt-get install -y nodejs

# Install PostgreSQL 17
apt-get install -y postgresql-17
systemctl enable postgresql
systemctl start postgresql
sudo -u postgres psql -c "ALTER USER postgres WITH PASSWORD 'your_secure_password';"

# Install Nginx
apt-get install -y nginx
systemctl enable nginx
systemctl start nginx

# Generate self-signed SSL certificate for HTTPS
openssl req -x509 -nodes -days 365 -newkey rsa:2048 \
  -keyout /etc/ssl/private/nginx-selfsigned.key \
  -out /etc/ssl/certs/nginx-selfsigned.crt \
  -subj "/C=US/ST=State/L=City/O=Organization/OU=Unit/CN=localhost"

# Configure Nginx for HTTPS
cat > /etc/nginx/sites-available/default << 'EOF'
server {
    listen 443 ssl;
    server_name _;

    ssl_certificate /etc/ssl/certs/nginx-selfsigned.crt;
    ssl_certificate_key /etc/ssl/private/nginx-selfsigned.key;

    location / {
        root /var/www/html;
        index index.html;
    }
}
EOF

systemctl restart nginx