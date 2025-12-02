# API Monitoring Dashboard

[![CI](https://github.com/code-xon/API-Monitoring-Dashboard/actions/workflows/ci.yml/badge.svg)](https://github.com/code-xon/API-Monitoring-Dashboard/actions/workflows/ci.yml)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Docker](https://img.shields.io/badge/Docker-Ready-blue)](https://docker.com)

A comprehensive, production-ready, open-source API monitoring platform built with Spring Boot and React. Monitor your APIs in real-time with health checks, alerting, SLA tracking, and beautiful dashboards.

## ✨ Features

### Core Monitoring
- 🔍 **Health Checks**: Configurable HTTP checks with custom headers, payloads, and timeouts
- 📊 **Real-time Metrics**: Uptime, latency, status codes, response times
- 🚨 **Smart Alerting**: Rule-based alerts with email/webhook notifications
- 📈 **SLA Tracking**: Monitor service level agreements with violation reports
- 🌍 **Multi-Environment**: Support for Dev, QA, Prod environments

### User Management
- 🔐 **JWT Authentication**: Secure login with role-based access control
- 👥 **Multi-User**: Admin and user roles with session management
- 📧 **Email Verification**: Password reset and account verification

### Advanced Features
- 🏷️ **API Grouping & Tagging**: Organize APIs with groups and tags
- 🔄 **Real-time Updates**: WebSocket-powered live dashboards
- 📋 **Audit Logging**: Track all user actions and system events
- 📤 **Export/Import**: CSV exports and JSON API imports
- 🧹 **Auto Cleanup**: Scheduled log archiving and cleanup

### DevOps & Operations
- 🐳 **Docker Ready**: Complete containerization with docker-compose
- 🔧 **CI/CD**: GitHub Actions for automated testing and deployment
- 📚 **API Documentation**: Auto-generated Swagger UI
- 🧪 **Testing**: Unit and integration tests included
- 📖 **Documentation**: Comprehensive setup and API guides

## 🏗️ Architecture

```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│   React UI      │    │  Spring Boot    │    │   PostgreSQL    │
│   (Frontend)    │◄──►│   (Backend)     │◄──►│   (Database)    │
│                 │    │                 │    │                 │
│ - Dashboard     │    │ - REST APIs     │    │ - APIs          │
│ - API Mgmt      │    │ - Health Checks │    │ - Logs          │
│ - Alerts        │    │ - Alert Engine  │    │ - Users         │
│ - Real-time     │    │ - JWT Auth      │    │ - Metrics       │
└─────────────────┘    └─────────────────┘    └─────────────────┘
                              ▲
                              │
                       ┌─────────────────┐
                       │     Redis       │
                       │   (Caching)     │
                       └─────────────────┘
```

## 🚀 Quick Start

### Prerequisites
- Docker & Docker Compose
- Git

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/code-xon/API-Monitoring-Dashboard.git
   cd API-Monitoring-Dashboard
   ```

2. **Start the services**
   ```bash
   cd docker
   docker-compose up -d
   ```

3. **Access the application**
   - **Frontend**: http://localhost:3000
   - **Backend API**: http://localhost:8080
   - **API Docs**: http://localhost:8080/swagger-ui.html
   - **Database Admin**: http://localhost:5050 (admin@example.com / admin)
   - **Email Testing**: http://localhost:8025

4. **Login**
   - **Default User**: admin@example.com
   - **Password**: Password123!

## 📚 Documentation

- [📖 Setup Guide](docs/setup.md) - Detailed installation and configuration
- [🔗 API Documentation](docs/api.md) - Complete API reference
- [🤝 Contributing](CONTRIBUTING.md) - How to contribute
- [📜 License](LICENSE) - MIT License

## 🛠️ Tech Stack

### Backend
- **Java 17** - Runtime
- **Spring Boot 3.x** - Framework
- **Spring Security** - Authentication & Authorization
- **Spring Data JPA** - Database ORM
- **PostgreSQL** - Primary database
- **Redis** - Caching & sessions
- **JUnit 5** - Testing

### Frontend
- **React 18** - UI Framework
- **TypeScript** - Type safety
- **Vite** - Build tool
- **Tailwind CSS** - Styling
- **Recharts** - Data visualization
- **Axios** - HTTP client
- **Jest** - Testing

### DevOps
- **Docker** - Containerization
- **Docker Compose** - Multi-service orchestration
- **GitHub Actions** - CI/CD
- **Maven** - Java build tool
- **NPM** - Node package manager

## 🔧 Configuration

### Environment Variables
```bash
# Database
DB_HOST=postgres
DB_PORT=5432
DB_NAME=monitor
DB_USER=monitor
DB_PASSWORD=monitorpass

# Authentication
JWT_SECRET=your-secret-key

# Email (SMTP)
SMTP_HOST=smtp-test
SMTP_PORT=1025

# Frontend
FRONTEND_URL=http://localhost:3000
```

### Default Ports
- Frontend: 3000
- Backend: 8080
- Database: 5432
- Redis: 6379
- PgAdmin: 5050
- MailHog: 8025

## 🧪 Testing

### Backend Tests
```bash
cd backend
mvn test
```

### Frontend Tests
```bash
cd frontend
npm test
```

### Integration Tests
```bash
cd docker
docker-compose -f docker-compose.test.yml up
```

## 🤝 Contributing

We welcome contributions! Please see our [Contributing Guide](CONTRIBUTING.md) for details.

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests
5. Submit a pull request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- Built with ❤️ using Spring Boot and React
- Inspired by modern monitoring platforms
- Thanks to the open-source community

---

**Made with ❤️ by Ramkrishna**

**Lead Developer**: Ramkrishna  
**Support Email**: ramkrishna@code-xon.fun  
**GitHub**: [@code-xon](https://github.com/code-xon)

[⭐ Star this repo](https://github.com/code-xon/API-Monitoring-Dashboard) if you find it useful!