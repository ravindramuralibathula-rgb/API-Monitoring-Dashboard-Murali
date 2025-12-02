# Setup Guide

## Prerequisites

- Docker and docker-compose

## Quick Start

1. Clone the repository
2. cd docker
3. docker-compose up
4. Open http://localhost:3000 for frontend
5. Open http://localhost:8080/swagger-ui.html for API docs
6. PgAdmin at http://localhost:5050
7. MailHog at http://localhost:8025

## Environment Variables

- DB_HOST, DB_PORT, DB_NAME, DB_USER, DB_PASSWORD
- JWT_SECRET
- SMTP_HOST, SMTP_PORT
- FRONTEND_URL