# 📱 Mobile Management System

### Spring Boot + JPA REST API for Managing Mobile Phone Inventory

A backend REST API built with **Spring Boot**, **Spring Data JPA**, **Hibernate**, and **MySQL** for managing a catalog of mobile phones — brand, model, price, and stock.

![Java](https://img.shields.io/badge/Java-25-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0.6-brightgreen)
![MySQL](https://img.shields.io/badge/Database-MySQL-blue)
![Maven](https://img.shields.io/badge/Build-Maven-yellow)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen)

---

## 📌 Project Overview

This project exposes a full set of CRUD REST endpoints for managing mobile phone records, backed by a MySQL database via Spring Data JPA. It follows a layered architecture — **Controller → Service → Repository → Entity** — with DTO-based request/response validation and a dedicated converter for entity/DTO mapping.

Each mobile record tracks:

- 🏷️ **Brand**
- 📱 **Model**
- 💰 **Price**
- 📦 **Stock**

---

## 🚀 Features

✅ Add a new mobile phone record
✅ Retrieve all mobile phones
✅ Retrieve a single mobile phone by ID
✅ Update an existing mobile phone
✅ Delete a mobile phone by ID
✅ Request validation (`@NotBlank`, `@Min`) on brand, model, price, and stock
✅ Custom exception handling for missing records
✅ Auto-seeded sample data on startup via `CommandLineRunner`

---

## 🛠️ Tech Stack

| Technology       | Purpose                     |
| ----------------- | ---------------------------- |
| Java 25            | Core language                |
| Spring Boot 4.0.6  | Application framework        |
| Spring Data JPA    | Database operations          |
| Hibernate          | ORM                          |
| MySQL              | Data storage                 |
| Lombok              | Boilerplate reduction        |
| Maven               | Build & dependency management |

---

## 📂 Project Structure

```
src/main/java/com/example
│
├── controller
│   └── MobileController.java
│
├── entity
│   └── Mobile.java
│
├── dto
│   └── MobileDto.java
│
├── repository
│   └── MobileRepository.java
│
├── service
│   ├── MobileService.java
│   └── impl
│       └── MobileServiceImpl.java
│
├── config
│   ├── Converter.java
│   └── DataLoader.java
│
├── exception
│   └── MobileNotFoundException.java
│
└── MobileManagementApplication.java
```

---

## 🗄️ Database Design

### `mobiledata` Table

| Column | Type    | Notes                        |
| ------ | ------- | ----------------------------- |
| id     | Long    | Auto-generated primary key    |
| brand  | String  | Required                      |
| model  | String  | Required                      |
| price  | Double  | Must be ≥ 100                 |
| stock  | Integer | Must be ≥ 10                  |

---

## 🚀 API Endpoints

| Method | Endpoint     | Description                  |
| ------ | ------------ | ----------------------------- |
| POST   | `/api`       | Add a new mobile              |
| GET    | `/api`       | Get all mobiles               |
| GET    | `/api/{id}`  | Get a mobile by ID            |
| PUT    | `/api/{id}`  | Update an existing mobile     |
| DELETE | `/api/{id}`  | Delete a mobile by ID         |

### Sample Request — Add a Mobile

```
POST /api
Content-Type: application/json
```

```json
{
  "brand": "Samsung",
  "model": "Galaxy A26",
  "price": 90000.0,
  "stock": 10
}
```

### Sample Response

```json
{
  "id": 1,
  "brand": "Samsung",
  "model": "Galaxy A26",
  "price": 90000.0,
  "stock": 10
}
```

---

## ⚙️ Installation & Setup

### Prerequisites

- JDK 25
- Maven
- MySQL Server running locally (or accessible remotely)

### Clone the repository

```bash
git clone https://github.com/Rupsa667/mobile-management-system-using-mysql.git
cd mobile-management-system-using-mysql
```

### Configure the database

Create a database in MySQL, then set your credentials in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/mobile_db
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> On first run, `DataLoader` automatically seeds the table with 4 sample mobiles (Samsung, Nokia, Oppo, Lenovo) via `CommandLineRunner`.

### Run the application

Using Maven:

```bash
mvn spring-boot:run
```

or, using the Maven wrapper:

```bash
./mvnw spring-boot:run
```

The API will be available at `http://localhost:8080/api`.

---

## 📖 JPA Concepts Demonstrated

- Entity mapping with `@Entity`, `@Id`, `@GeneratedValue`
- DTO pattern using Java `record` with Bean Validation (`@NotBlank`, `@Min`)
- Manual entity–DTO conversion via a dedicated `Converter` utility class
- Repository pattern with `JpaRepository`
- Custom runtime exceptions for not-found scenarios
- Startup data seeding via `CommandLineRunner`

---

## 🎯 Learning Outcomes

By studying this project you will understand:

- Spring Boot project structure and layered architecture
- Spring Data JPA and Hibernate ORM basics
- Request validation using Jakarta Bean Validation
- DTO ↔ Entity conversion patterns
- REST API development and testing
- Seeding initial data on application startup

---

## 👩‍💻 Author

**Rupsa**

---

### ⭐ If you found this project helpful, consider starring the repository!
