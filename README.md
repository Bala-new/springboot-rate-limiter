
# 🚦 Spring Boot Sliding Window Rate Limiter

A lightweight backend rate-limiting system built using **Java**, **Spring Boot**, and in-memory Java data structures. This project implements a **Sliding Window** algorithm to prevent clients from sending too many requests in a short period of time.

---

## 🧠 What It Does

This backend service:
- Accepts HTTP requests via a REST API
- Tracks request frequency using user IP (or can be extended to user ID/session)
- Uses a **sliding window algorithm** to limit requests (e.g., 5 requests per minute)
- Returns `429 Too Many Requests` if the limit is exceeded

---

## ⚙️ Technologies Used

| Tech            | Purpose                         |
|-----------------|---------------------------------|
| Java 17+        | Programming language            |
| Spring Boot     | REST API and lifecycle          |
| Spring MVC      | Interceptor for request control |
| In-Memory Map   | Store user request logs         |
| Deque (Queue)   | Track timestamps per user       |
| Maven           | Build system                    |

---

## 📁 Project Structure

```
src/
 └── main/
     └── java/
         └── com.example.ratelimiter/
             ├── controller/RateLimitController.java
             ├── interceptor/RateLimitInterceptor.java
             ├── service/RateLimitService.java
             ├── config/WebConfig.java
             └── model/RequestInfo.java
```

---

## 🧪 How the Sliding Window Algorithm Works

1. Each user/IP has a queue of timestamps.
2. On each new request:
   - Remove timestamps older than 60 seconds
   - If queue has less than 5 requests → allow and add new timestamp
   - Else → reject with `429`

✅ This ensures **accurate**, **smooth**, and **time-based** rate limiting.

---

## 🚀 How to Run

### 1. Clone the Repo

```bash
git clone https://github.com/Bala-new/springboot-rate-limiter.git
cd springboot-rate-limiter
```

### 2. Run the App

Using Maven wrapper:
```bash
./mvnw spring-boot:run
```

Or using your IDE (IntelliJ, VS Code) with the main class.

---

## 🔎 Sample Endpoint

```
GET http://localhost:8080/api/test
```

- Returns `200 OK` if under limit
- Returns `429 Too Many Requests` if over limit

---

## 🧩 Possible Extensions

- 🔐 Per-user rate limit (JWT/session-based)
- 🧠 Per-endpoint rate limits (based on URI)
- 📊 Logging + metrics (Prometheus, Actuator)
- 🧪 Unit tests for service/interceptor
- ☁️ Redis-backed distributed rate limiting

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).

---

## 👨‍💻 Author

**Balamuruganandham**  
Feel free to connect:  
[LinkedIn](https://www.linkedin.com/in/balamuruganandham) • [GitHub](https://github.com/Bala-new)
