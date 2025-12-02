# Contributing

Thank you for your interest in contributing to API Monitoring Dashboard!

## Development Setup

1. Clone the repo
2. Run `docker-compose up` to start all services
3. Backend: http://localhost:8080
4. Frontend: http://localhost:3000

## Branching Model

- `main`: Production-ready code
- `develop`: Development branch
- Feature branches: `feature/<feature-name>`

## Commit Messages

Use conventional commits: `feat:`, `fix:`, `docs:`, etc.

## Testing

- Run backend tests: `./mvnw test`
- Run frontend tests: `npm test`
- Integration tests via docker-compose

## Pull Requests

- Ensure tests pass
- Update documentation if needed
- Follow code style