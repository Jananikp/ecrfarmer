variable "region" {
  default     = "ap-south-1"
  description = "AWS region"
}

variable "vpc_cidr" {
  default     = "10.0.0.0/16"
  description = "VPC CIDR block"
}

variable "subnet_cidr" {
  default     = "10.0.1.0/24"
  description = "Subnet CIDR block"
}

variable "availability_zone" {
  default     = "ap-south-1a"
  description = "Availability zone for subnet"
}

variable "ssh_cidr" {
  description = "CIDR block for SSH access (your IP)"
  type        = string
}

variable "key_name" {
  description = "Name of the SSH key pair in AWS"
  type        = string
}