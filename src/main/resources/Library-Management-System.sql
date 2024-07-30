DROP DATABASE IF EXISTS Library_Management_System;
CREATE DATABASE IF NOT EXISTS Library_Management_System;
USE Library_Management_System;

CREATE TABLE IF NOT EXISTS Book
(
    id               INT PRIMARY KEY AUTO_INCREMENT,
    title            VARCHAR(255) NOT NULL,
    author           VARCHAR(255) NOT NULL,
    isbn             VARCHAR(255) NOT NULL UNIQUE,
    publication_year INT          NOT NULL,
    quantity         INT          NOT NULL CHECK (quantity >= 0)
);

CREATE TABLE IF NOT EXISTS Patron
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    name         VARCHAR(255) NOT NULL,
    email        VARCHAR(255) NOT NULL UNIQUE,
    phone_number VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Loan
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    book_id     INT  NOT NULL,
    patron_id   INT  NOT NULL,
    loan_date   DATE NOT NULL,
    return_date DATE,
    FOREIGN KEY (book_id) REFERENCES Book (id),
    FOREIGN KEY (patron_id) REFERENCES Patron (id),
    CHECK (return_date IS NULL OR return_date >= loan_date)
);