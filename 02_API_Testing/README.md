# Restful Booker API Automation Framework

## Overview

This repository contains a layered API automation framework built against the Restful Booker API. The purpose of this project is to demonstrate SDET-level framework design, clean architecture, and scalable test automation practices using Java.

System Under Test: Restful Booker API  
Documentation: https://restful-booker.herokuapp.com/apidoc/index.html

---

## Technology Stack

- Java
- Rest Assured
- TestNG
- Jackson (FasterXML)
- SLF4J with Logback
- Allure Reporting
- Java Faker
- Maven

---

## Architecture

The framework follows a layered structure to ensure separation of concerns and maintainability.

```        
├───allure-reports                  # Allure html report
│   ├───data
│   │   ├───attachments
│   │   └───test-cases
│   ├───export
│   ├───history
│   ├───plugin
│   │   ├───behaviors
│   │   ├───packages
│   │   └───screen-diff
│   └───widgets
├───allure-results
├───src
│   └───test
│       ├───java
│       │   ├───assertions          # Custom assertion DSL
│       │   ├───client              # API client layer
│       │   ├───config              # Environment configuration
│       │   ├───data                # Test data faker
│       │   ├───filter              # Logging and reporting filters
│       │   ├───mapper              # Centralized response deserialization
│       │   ├───models              # Request and response POJOs
│       │   │   ├───auth
│       │   │   └───booking
│       │   ├───tests               # Test scenarios
│       │   │   └───base
│       │   └───utils
│       └───resources
│           ├───config              # Environment configuration properties
│           ├───schemas             # JSON schema validation files
```

---

## Framework Design Principles

- Separation of concerns
- Reusable abstraction layers
- Centralized configuration
- Clean and readable test code
- Scalable structure
- CI-ready reporting
- Contract validation through schema testing

---

## Key Components

### API Client Layer

All HTTP interactions are encapsulated inside dedicated client classes. Tests do not directly call Rest Assured methods.

Example:

```java
BookingClient bookingClient = new BookingClient(requestSpec);
Response response = bookingClient.createBooking(request);
```

This ensures business-level operations are reusable and isolated from test logic.

---

### Faker-Based Test Data

Payloads are constructed using a fakers.

Example:

```java
LocalDate  checkIn = FakerUtils.randomDate();
LocalDate checkout = FakerUtils.randomDate(checkIn);
BookingDates bookingDates = new BookingDates(checkIn.toString(), checkout.toString());

BookingRequest bookingRequest = new BookingRequest(
        FakerUtils.randomFirstName(),
        FakerUtils.randomLastName(),
        FakerUtils.randomPrice(),
        true,
        bookingDates,
        FakerUtils.randomAdditionalNeeds()
);
```

This avoids hardcoded JSON and improves readability and maintainability.

Randomized but realistic test data is generated using Java Faker. This prevents static data reuse and improves test robustness.

---

### Response Mapper Layer

All deserialization is centralized through a ResponseMapper class using Jackson. Tests do not perform manual JSON parsing.

Example:

```java
BookingResponse bookingResponse =
    ResponseMapper.map(response, BookingResponse.class);
```

---

### Custom Assertion DSL

A fluent assertion layer provides readable validation.

Example:

```java
Response response = bookingClient.createBooking(bookingRequest);
        ResponseAssertions.assertThat(response)
                .hasStatusCode(200)
                .matchesSchema("schemas/create-booking-schema.json")
                .hasResponseTimeBelow(ConfigManager.getMaxResponseTime())
        .hasFistName(bookingRequest.firstname())
        .hasLastName(bookingRequest.lastname());
```

Domain-specific assertions are also supported.

---

### JSON Schema Validation

Contract validation is performed using JSON schema files located in:

```
src/test/resources/schemas
```

This ensures response structures remain consistent with expected contracts.

---

### Structured Logging

Logging is implemented using SLF4J and Logback.

Features:

- Console logging
- File-based logging
- Rolling log files
- Conditional logging on failure
- Debug mode via JVM property

Enable debug mode:

```bash
mvn test -Ddebug=true
```

---

### Allure Reporting

Test execution results are integrated with Allure.

Features:

- Automatic request and response attachments
- Attachments on failure
- Static report generation
- CI-friendly reporting

Run tests:

```bash
mvn clean test
```

Generate static report:

```bash
allure generate allure-results --clean -o allure-report
```

Open report:

```
allure-report/index.html
```

---

### Authentication Management

Authentication is handled by a centralized token manager with:

- Environment-driven credentials

---

## Configuration

Configuration is managed via:

```
src/test/resources/config.properties
```

Example:

```
base.url=https://restful-booker.herokuapp.com
username=admin
password=password123
```

This allows environment-based execution and CI integration.

---

## Example Test Coverage

The framework includes lifecycle validation for bookings:

1. Create booking
2. Retrieve booking
3. Update booking
4. Delete booking
5. Verify deletion

Each test uses:

- API client abstraction
- Faker based payload construction
- Response mapping
- Custom assertions
- Schema validation
- Structured logging
- Allure reporting

---

## How to Run

Run tests:

```bash
mvn clean test -Ddebug=true
```

Generate Allure report:

```bash
allure generate allure-results --clean -o allure-report
```

Alternatively:

```bash
mvn clean test allure:report
```

---

## What This Project Demonstrates

- Scalable API automation architecture
- Clean separation between test logic and HTTP layer
- Reusable test data generation patterns
- Contract validation practices
- Reporting integration suitable for CI environments
- Logging strategy aligned with production standards

This repository reflects framework-level automation design rather than isolated test scripts.