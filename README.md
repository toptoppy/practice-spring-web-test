# FX Account Balance Service

This repository provides a **Spring Boot + Kotlin** application that simulates a **Foreign Exchange (FX) Account Service**. 
The service allows retrieving account balances in foreign currencies and converting them to **Thai Baht (THB)** using exchange rates.

## Features

- Retrieve account balances in different foreign currencies
- Convert balances to **THB** using exchange rates
- Store account and exchange rate data in a **PostgreSQL database**
- Comprehensive testing using **JUnit 5**, **Spring Boot Test**, and **MockMvc**

---

## Tech Stack

- **Kotlin**
- **Spring Boot** (Web, JPA, Test)
- **PostgreSQL**
- **JUnit 5 & MockMvc**

---

## Project Structure

```
fx-service/
│── src/main/kotlin/
│   ├── controller/  # REST API Controllers
│   ├── service/     # Business Logic
│   ├── repository/  # JPA Repositories
│   ├── entity/      # Database Entities
│── src/test/kotlin/ # Unit and Integration Tests
│── build.gradle.kts # Build Configuration
│── README.md        # Project Documentation
```

---

## Getting Started

### Prerequisites

- **JDK 17+**
- **Docker**
- **Gradle**

### Setup & Run

#### Clone the Repository

```sh
git clone git@github.com:toptoppy/practice-spring-web-test.git
cd practice-spring-web-test
```

#### Run the Application

```sh
./gradlew bootRun
```

#### Run Tests

```sh
./gradlew test
```

#### Run Lint Check

```sh
./gradlew ktlintCheck
```

#### Run Lint Formatting

```sh
./gradlew ktlintFormat
```
---

## API Endpoints

### Get Balance in THB

**Request:**

```http
GET /fx/{accountId}/balance-thb
```

**Response:**

```json
{
  "balanceInTHB": 3500.0
}
```

---

## Database Schema

### **FxAccountEntity** (Table: `fx_account`)

| Column    | Type   | Description                    |
| --------- | ------ | ------------------------------ |
| accountId | String | Account ID                     |
| balance   | Double | Account Balance                |
| currency  | String | Currency Code (e.g., USD, EUR) |

### **ExchangeRateEntity** (Table: `exchange_rate`)

| Column   | Type   | Description   |
| -------- | ------ | ------------- |
| currency | String | Currency Code |
| sellRate | Double | Sell Rate     |
| buyRate  | Double | Buy Rate      |

---

