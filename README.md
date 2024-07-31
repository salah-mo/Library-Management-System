# Library Management System

## Overview

The Library Management System is a Spring Boot application designed to manage the operations of a library. It includes
functionalities for managing books, patrons, and loans.

## Features

- **Book Management**: Add, update, delete, and retrieve books.
- **Loan Management**: Loan and return books to/from patrons.
- **Patron Management**: Manage library patrons (not shown in the provided code but assumed to be part of the system).

## Technologies Used

- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **Jakarta Validation**
- **Maven**
- **SQL**

## Prerequisites

- Java 17 or higher
- Maven 3.6.0 or higher
- A SQL database (e.g., MySQL, PostgreSQL)

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/salah-mo/library-management-system.git
cd library-management-system
```

### Configure the Database

Update the `application.properties` file located in `src/main/resources` with your database configuration.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/library_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### Build the Project

```bash
mvn clean install
```

### Run the Application

```bash
mvn spring-boot:run
```

## API Endpoints

### Book Controller

- **Get all books**: `GET /api/books`
- **Get a book by ID**: `GET /api/books/{id}`
- **Add a new book**: `POST /api/books`
- **Update a book**: `PUT /api/books/{id}`
- **Delete a book**: `DELETE /api/books/{id}`

### Patron Controller

- **Get all patrons**: `GET /api/patrons`
- **Get a patron by ID**: `GET /api/patrons/{id}`
- **Add a new patron**: `POST /api/patrons`
- **Update a patron**: `PUT /api/patrons/{id}`
- **Delete a patron**: `DELETE /api/patrons/{id}`

### Loan Controller

- **Loan a book to a patron**: `POST /api/borrow/{bookId}/patron/{patronId}`
- **Return a book from a patron**: `PUT /api/return/{bookId}/patron/{patronId}`

### API Documentation

[API Documentation](API%20documentation.md)