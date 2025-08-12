# 🚦 Spring Boot Secure Per-User Rate Limiter

A secure backend rate-limiting system built using **Java**, **Spring Boot**, and **Spring Security**.  
This project implements a **Fixed Window** (can be extended to Sliding Window) algorithm with **per-user** limits to protect APIs from abuse.

---

## 🧠 What It Does

This backend service:
- Authenticates users using **Spring Security** with **BCrypt password hashing**
- Tracks request frequency **per authenticated user** (not just IP)
- Uses an **interceptor** to enforce request limits before hitting the controller
- Returns `429 Too Many Requests` if a user exceeds the limit
- Allows **role-based access control** for different endpoints

---

## ⚙️ Technologies Used

| Tech            | Purpose                                     |
|-----------------|---------------------------------------------|
| Java 17+        | Programming language                        |
| Spring Boot     | REST API framework                          |
| Spring Security | Authentication & authorization              |
| Spring MVC      | Interceptor for request rate limiting       |
| Spring Data JPA | Database access for storing users           |
| BCrypt          | Password hashing for secure storage         |
| Maven           | Build system                                |
| H2 Database     | In-memory DB for demo purposes              |

---

## 📁 Project Structure

```
src/
 └── main/
     └── java/
         └── com.example.ratelimiter/
             ├── controller/
             │    ├── RateLimitController.java
             │    └── AdminController.java
             ├── interceptor/
             │    └── RateLimitInterceptor.java
             ├── service/
             │    ├── RateLimitService.java
             │    ├── myUserDetailService.java
             │    └── UserService.java
             ├── config/
             │    ├── SecurityConfiguration.java
             │    └── WebConfig.java
             ├── model/
             │    ├── RequestInfo.java
             │    └── Users.java
             └── repository/
                  ├── RateLimitRepository.java
                  └── UserDetailsRepo.java
```

---

## 🔐 How Per-User Rate Limiting Works

1. User logs in with a username & password (stored securely with BCrypt)
2. `RateLimitInterceptor` gets the username from:
   ```java
   SecurityContextHolder.getContext().getAuthentication().getName();
   ```
3. `RateLimitService` checks if the user exceeded the allowed requests in the time window
4. If within limit → request proceeds  
   If over limit → returns `429 Too Many Requests`

✅ This ensures **fair API usage** and **security per authenticated user**.

---

## 🚀 How to Run

### 1. Clone the Repo

```bash
git clone https://github.com/Bala-new/springboot-rate-limiter-secure.git
cd springboot-rate-limiter-secure
```

### 2. Run the App

Using Maven wrapper:
```bash
./mvnw spring-boot:run
```

Or run the `main` class from your IDE.

---

## 🔎 Sample Endpoints

```
POST /api/admin/add-user
```
- Registers a new user with hashed password

```
GET /api/test
```
- Rate-limited per user (max X requests per minute)

---

## 🧩 Possible Extensions

- ⏳ Switch to **Sliding Window** algorithm for smoother limits
- ☁️ Redis-backed distributed rate limiting for multi-instance setups
- 🛡️ JWT-based stateless authentication
- 📊 Logging & monitoring with Spring Boot Actuator + Prometheus
- 🧪 Unit and integration tests for rate limiter and security

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).

---

## 👨‍💻 Author

**Balamuruganandham**  
[LinkedIn](https://www.linkedin.com/in/balamuruganandham) • [GitHub](https://github.com/Bala-new)
