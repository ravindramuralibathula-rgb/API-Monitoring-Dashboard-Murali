# API Documentation

## Authentication

- POST /api/auth/register - Register a new user
- POST /api/auth/login - Login and get JWT token

## APIs

- GET /api/apis - List monitored APIs
- POST /api/apis - Create a new API
- GET /api/apis/{id} - Get API details
- PUT /api/apis/{id} - Update API
- DELETE /api/apis/{id} - Delete API

## Logs

- GET /api/logs/{apiId} - Get health check logs for an API

## Alerts

- GET /api/alerts/rules - List alert rules
- POST /api/alerts/rules - Create alert rule
- GET /api/alerts/events - List alert events
- PUT /api/alerts/events/{id}/ack - Acknowledge alert

## SLA

- GET /api/sla/profiles - List SLA profiles
- POST /api/sla/profiles - Create SLA profile
- GET /api/sla/uptime/{apiId} - Get uptime for API