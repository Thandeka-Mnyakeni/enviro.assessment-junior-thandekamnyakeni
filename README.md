READMe.md

Enviro365 - Junior Developer Assessment - June 2026

Candidate: Thandeka Mnyakeni
Package:’com.enviro.assessment.junior.thandekamnyakeni’
Tech Stack: Spring Boot 3.2.0, H2 Database, JPA, HTML + JavaScript, Java 17

Full-stack solution for Enviro365 to automate the Withdrawal Notice process.

How to Run

- Java 17+
- Maven
- Any browser

1. Backend - Spring Boot
bash
cd backend
mvn clean install
mvn spring-boot:run

Backend runs at: ‘http://localhost:8080’
H2 Console: ‘http://localhost:8080/h2-console’

2. Frontend - HTML + JavaScript
1. Make sure backend is running on port 8080
2. Double-click ‘index.html’ to open  in browser

API Documentation 
Base URL: `http://localhost:8080/api`

GET
‘api/investors/{id}/portfolio’ - Retrieve investor portfolio (details + products)

POST
‘/api/withdrawals’ - Create withdrawal notice with validation

GET
‘/api/withdrawals/{investorId}’ - Get withdrawal history

GET
‘/api/withdrawals/export?investorId=1’ - Export CSV statement with filtering


Business Rules Implemented

1. Retirement Age Rule: ‘if productType == RETIREMENT && age <= 65’ -> Reject with message: “Retirement withdrawals only allowed if age > 65. Your age: X”
2. Balance Check: ‘if amount > product.balance’ -> Reject: “Withdrawal exceeds balance”
3. 90% Rule: ‘maxAllowed = balance * 0.9’-> ‘if amount > maxAllowed’-> Reject: “Cannot withdraw more than 90%... Max allowed: R...”
4. Balance Update: On success, product balance is deducted and saved.

Advanced Features 

1. Global Exception Handling
File: ‘Exception/GlobalExceptionHandler.java’
Uses ‘@RestControllerAdvice’ to catch ‘BusinessException’ and ‘MethodArgumentNotValidException’ and return clean JSON error.

2. DTO Layer
Files: ‘DTOs/ DTOs.java’, 
Entities are not exposed directly. Uses Java ‘record’ for immutability. Keeps API clean and secure.

3. Input Validation
Uses ‘jakarta.validation’ annotations:
- ‘@NotNull’, ‘@NotBlank’ , ‘@Min(1)’ on DTO
- ‘@Valid’ in Controller
- Frontend also validates: checks ‘amount > 0’ before sending, shows error messages.

Project Structure

enviro.assessment/
│ └── src/main/java
│ │ ├── api/Rest.java
│ │ ├── entities/
│ │ │ ├── Investor.java
│ │ │ ├── Product.java
│ │ │ └── WithdrawNotice.java
│ │ ├──DTOs/
│ │ │ ├── DTOs.java
│ │ ├── exception/
│ │ │ ├── BusinessException.java
│ │ │ └── GlobalExceptionHandler.java
│ │ ├── repository/ Repo.java
│ │ ├── service/Service.java
│ └── src/main/resources/application.properties
└── index.html 

Frontend Features

Single file ‘index.html’ includes all required UI:

1. Portfolio Dashboard: Shows name, age, total balance, list of products. Input to change investor ID.
2. Withdrawal Form: Select product type (RETIREMENT/SAVINGS), enter amount, submit. Shows success/error message.
3. Withdrawal History Table: Lists id, product, amount, date, status. Refresh button.
4. CSV Download Button: Calls ‘/export’ endpoint and downloads file using ‘window.location.href’.

Uses ‘fetch().then().then()’

AI Usage Disclosure

Tool Used: Meta AI 

What was assisted:
- Boilerplate for Spring Boot models, repositories, and ‘DataLoader’
- Suggestion for CSV export using ‘HttpServletResponse’ and ‘PrintWriter’
- Frontend ‘fetch().then()’ structure for JavaScript.

- <img width="700" height="436" alt="enviro index" src="https://github.com/user-attachments/assets/6a020998-9e46-42a0-a8ba-ab217df7c346" />
