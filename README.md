<div align="center">

# 🏋️ Fitness App Backend

A production-ready REST API built using **Spring Boot**, featuring secure JWT authentication, role-based access control, DTO-based architecture, request validation, centralized exception handling, and AI-powered fitness assistance via Google Gemini.

<p>
<img src="https://img.shields.io/badge/Java-21-orange">
<img src="https://img.shields.io/badge/Spring_Boot-3.x-brightgreen">
<img src="https://img.shields.io/badge/PostgreSQL-NeonDB-blue">
<img src="https://img.shields.io/badge/Security-JWT-success">
<img src="https://img.shields.io/badge/Docker-Enabled-2496ED">
<img src="https://img.shields.io/badge/Deployment-Render-purple">
<img src="https://img.shields.io/badge/API-OpenAPI-green">
</p>

</div>

---

# 📖 Overview

Fitness App Backend is a secure and scalable REST API designed using Spring Boot and PostgreSQL. It follows clean architecture principles and includes modern backend practices such as DTO-based communication, request validation, centralized exception handling, JWT security, and API documentation.

---

# 🚀 Tech Stack

| Category | Technology |
|------------|------------|
| Language | Java 21 |
| Framework | Spring Boot |
| Security | Spring Security + JWT |
| Database | PostgreSQL |
| Cloud Database | NeonDB |
| ORM | Hibernate + Spring Data JPA |
| AI Integration | Google Gemini API |
| API Documentation | Swagger / OpenAPI |
| Validation | Jakarta Validation |
| Containerization | Docker |
| Deployment | Render |
| Build Tool | Maven |

---



# ✨ Features

## 🔐 Authentication & Authorization

- User Registration
- User Login
- JWT-based Authentication
- Stateless Security
- BCrypt Password Encryption
- Role-Based Access Control (RBAC)

---

## 📦 DTO-Based Architecture

- Request DTOs
- Response DTOs
- Separation between API layer and persistence layer
- Improved maintainability and scalability

---

## ✅ Input Validation

Implemented using Jakarta Validation annotations:

- `@NotBlank`
- `@NotNull`
- `@Email`
- `@Size`
- `@Pattern`

Benefits:

- Prevents invalid requests
- Provides meaningful error messages
- Ensures API reliability

---

## ⚠️ Global Exception Handling

Centralized exception handling using:

```java
@RestControllerAdvice
```

Handles:

- Validation exceptions
- Resource not found exceptions
- Authentication errors
- Business exceptions
- Unexpected server errors

Provides:

- Standardized API responses
- Cleaner controller code
- Better client experience

---

## 📚 API Documentation

Interactive API documentation powered by:

- Swagger UI
- OpenAPI 3

Capabilities:

- Endpoint descriptions
- Request and response schemas
- Authentication support
- API testing directly from browser

---

## 📝 Logging

Application logging is implemented to improve debugging and monitoring.

### Features

- Centralized logging configuration
- Automatic log generation during application execution
- Persistent log files stored in the project's root `logs/` directory
- Error and event tracking
- Easier troubleshooting and maintenance

### Log Directory

```text
fitness-app
│
├── logs
│     └── application.log
│
├── src
├── pom.xml
└── Dockerfile
```

### Benefits

- Monitor application behavior
- Track exceptions and failures
- Simplify debugging
- Maintain execution history
- Improve observability

---

## 🤖 AI Assistant

Powered by Google Gemini API:

- Fitness recommendations
- Intelligent conversations
- Personalized assistance

---


# 📡 API Reference

Base URL:

```text
https://fitness-app-ye5s.onrender.com
```

---

## 🔐 Authentication APIs

### Register User

```http
POST /api/users/register
```

**Endpoint**

```text
https://fitness-app-ye5s.onrender.com/api/users/register
```

**Description**

Creates a new user account.

---

### Login User

```http
POST /api/users/login
```

**Endpoint**

```text
https://fitness-app-ye5s.onrender.com/api/users/login
```

**Description**

Authenticates a user and returns a JWT token.

---

## 🏋️ Activity APIs

### Get User Activities

```http
GET /api/activities
```

**Endpoint**

```text
https://fitness-app-ye5s.onrender.com/api/activities
```

### Required Header

```http
userId: <user_id>
```

### Example

```http
GET /api/activities HTTP/1.1
Host: fitness-app-ye5s.onrender.com
userId: 1
```

**Description**

Fetches all activities associated with the specified user.

---

## 🤖 AI Recommendation APIs

### Generate Recommendation

```http
POST /api/recommendation/generate
```

**Endpoint**

```text
https://fitness-app-ye5s.onrender.com/api/recommendation/generate
```

**Description**

Generates personalized fitness recommendations using Google Gemini AI.

---

### Get User Recommendations

```http
GET /api/recommendation/user/{userId}
```

**Example**

```text
https://fitness-app-ye5s.onrender.com/api/recommendation/user/1
```

**Description**

Returns recommendation history for a specific user.

---

# 📋 Endpoint Summary

| Method | Endpoint | Description |
|----------|----------|-------------|
| POST | `/api/users/register` | Register a new user |
| POST | `/api/users/login` | Login user |
| GET | `/api/activities` | Get activities for a user |
| POST | `/api/recommendation/generate` | Generate AI recommendations |
| GET | `/api/recommendation/user/{userId}` | Fetch user recommendation history |

---

# 🔑 Authentication Flow

```text
Register User
      ↓
Login User
      ↓
Receive JWT Token
      ↓
Access Protected APIs
      ↓
Manage Activities
      ↓
Generate AI Recommendations
```

---

# 🏗 Architecture

```text
                Client
                   │
                   ▼
             REST Controllers
                   │
                   ▼
                DTO Layer
                   │
                   ▼
             Service Layer
                   │
                   ▼
           Repository Layer
                   │
                   ▼
          PostgreSQL (NeonDB)
```


## ☁️ Cloud Deployment

### Backend

- Render

### Database

- NeonDB (PostgreSQL)

### Containerization

- Docker

---

# 🚀 Future Enhancements

- Refresh Token Support
- Email Verification
- Admin Dashboard
- Workout Progress Analytics
- Unit Testing
- Integration Testing
- CI/CD Pipeline with GitHub Actions
- Mobile Application Support
- Advanced Recommendation Engine

---

# 🤝 Contributing

Contributions, issues, and feature requests are welcome!

1. Fork the repository.
2. Create your feature branch:

```bash
git checkout -b feature/your-feature
```

3. Commit your changes:

```bash
git commit -m "Add some feature"
```

4. Push to the branch:

```bash
git push origin feature/your-feature
```

5. Open a Pull Request.

---

# 👨‍💻 Author

## Nikhil Rana

Backend Developer | Java & Spring Boot Enthusiast

---

# 📫 Contact

### GitHub

🔗 https://github.com/beingnikil07


### Email

📧 nikhilkumarrana07@gmail.com

---

# 🌟 Support

If you found this project useful, please consider giving it a ⭐ on GitHub.

It helps others discover the project and motivates further development.

---

<div align="center">

### Built with ❤️ using Java, Spring Boot, PostgreSQL, Docker, and Google Gemini AI

**Thank you for visiting the repository!**

</div>

