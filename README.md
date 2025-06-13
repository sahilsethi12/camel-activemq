# 📨 Apache Camel + Spring Boot + ActiveMQ Example

This project demonstrates how to use **Apache Camel 4** with **Spring Boot** and an **external ActiveMQ broker** to build a simple message-driven application using JMS (Java Message Service).

## 📋 What It Does

- A **producer route** generates random `Order` messages in JSON format every 5 seconds and sends them to an ActiveMQ queue.
- A **consumer route** listens to that queue, receives the messages, deserializes them into Java objects, and logs them.

## ⚙️ Technologies Used

- Java 21+
- Spring Boot
- Apache Camel 4
- ActiveMQ 5 or 6 (external broker)
- Gson (for JSON serialization)

## 🏗️ Project Structure

- `config/` – Configures connection to the ActiveMQ broker securely.
- `pojo/` – Contains the `Order` data class.
- `routes/` – Contains the Camel producer and consumer routes.
- `util/` – Utility class for JSON handling.
- `CamelActiveMqApplication.java` – Spring Boot main entry point.

## 🔐 Security

The application sets `trustedPackages` on the `ActiveMQConnectionFactory` to prevent unsafe deserialization. Broker connection details are loaded from `application.yml`.

## ▶️ How to Run

1. Start an ActiveMQ broker locally (default port: `61616`).
2. Update your `application.yml` if needed:
   ```yaml
   spring:
     activemq:
       broker-url: tcp://localhost:61616
       user: admin
       password: admin
3. Run the application:
   ``` 
   ./mvnw spring-boot:run
