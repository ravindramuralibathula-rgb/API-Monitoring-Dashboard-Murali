# API Monitoring Dashboard

An open-source application for monitoring HTTP APIs with real-time dashboards, alerting, and metrics.

## Features

- Register and monitor REST APIs with health checks
- JSON/YAML body support for POST checks
- Global and per-API timeouts, retry attempts
- Track latency, status codes, uptime (daily/weekly/monthly)
- Detailed log history with pagination and search
- JWT authentication with roles (Admin, User)
- Email + webhook alerts with thresholds
- Dashboard with charts, metrics, and real-time updates
- Environment support (Dev, QA, Prod)
- API grouping and tagging
- Multi-user system with user management
- SLA management (99.9%, 99.5%, 95%)
- SLA violation reports
- Dark mode UI
- Role-based access control
- Audit logging
- API versioning support
- Custom HTTP headers and payload templates
- Regex validation and keyword search in responses
- Log archiving and cleanup
- Export logs as CSV, metrics as JSON
- Import APIs via JSON
- API cloning and bulk operations
- Docker-compose microservices setup
- PgAdmin and MailHog for testing

## Tech Stack

- Backend: Java 17, Spring Boot 3.x
- Frontend: React 18, TypeScript, Tailwind CSS
- Database: PostgreSQL
- Caching/Queue: Redis
- Containerization: Docker, docker-compose

## Quickstart

Prerequisites: Docker and docker-compose

```bash
git clone <repo-url>
cd API-Monitoring-Dashboard
cd docker
docker-compose up
```

- Frontend: http://localhost:3000
- Backend API: http://localhost:8080
- Swagger UI: http://localhost:8080/swagger-ui.html
- PgAdmin: http://localhost:5050 (admin@example.com / admin)
- MailHog: http://localhost:8025

Default user: admin@example.com / Password123!

## Documentation

- [Setup Guide](docs/setup.md)
- [API Documentation](docs/api.md)

## Architecture

- **Backend**: Spring Boot with JPA, JWT auth, scheduled checks.
- **Frontend**: React with TypeScript, charts.
- **Database**: PostgreSQL for data, Redis for caching.
- **Real-time**: WebSocket for updates.
- **Containerization**: Docker Compose for local dev.

## API Documentation

Swagger UI: http://localhost:8080/swagger-ui.html

## Contributing

See [CONTRIBUTING.md](CONTRIBUTING.md)

## License

MIT