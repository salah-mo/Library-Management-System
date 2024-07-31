# API Documentation

## Book API Documentation

### Get All Books

- **URL:** `/api/books`
- **Method:** `GET`
- **Description:** Retrieves a list of all books in the library.
- **Response:**
    - **Status Code:** `200 OK`
    - **Body:** JSON array of book objects.
- **Example Request:**

```http
GET /api/books
```

- **Example Response:**

```json
[
  {
    "id": 1,
    "title": "Test Book",
    "author": "Test Author",
    "isbn": "1234567890",
    "publishYear": 2023,
    "quantity": 5
  }
]
```

### Get Book by ID

- **URL:** `/api/books/{id}`
- **Method:** `GET`
- **Description:** Retrieves a book by its ID.
- **Path Parameters:**
    - `id` (Long): The ID of the book to retrieve.
- **Response:**
    - **Status Code:** `200 OK`
    - **Body:** JSON object of the book.
- **Example Request:**

```http
GET /api/books/1
```

- **Example Response:**

```json
{
  "id": 1,
  "title": "Test Book",
  "author": "Test Author",
  "isbn": "1234567890",
  "publishYear": 2023,
  "quantity": 5
}
```

### Create a New Book

- **URL:** `/api/books`
- **Method:** `POST`
- **Description:** Adds a new book to the library.
- **Request Body:** JSON object representing the book to be created.
- **Response:**
    - **Status Code:** `201 Created`
    - **Body:** JSON object of the created book.
- **Example Request:**

```http
POST /api/books HTTP/1.1
Content-Type: application/json

{
  "title": "Test Book",
  "author": "Test Author",
  "isbn": "1234567890",
  "publishYear": 2023,
  "quantity": 5
}
```

- **Example Response:**

```json
{
  "id": 1,
  "title": "Test Book",
  "author": "Test Author",
  "isbn": "1234567890",
  "publishYear": 2023,
  "quantity": 5
}
```

### Update a Book

- **URL:** `/api/books/{id}`
- **Method:** `PUT`
- **Description:** Updates the details of an existing book by its ID.
- **Path Parameters:**
    - `id` (Long): The ID of the book to update.
- **Request Body:** JSON object representing the updated book details.
- **Response:**
    - **Status Code:** `200 OK`
    - **Body:** JSON object of the updated book.
- **Example Request:**

```http
PUT /api/books/1 HTTP/1.1
Content-Type: application/json

{
  "title": "Updated Book",
  "author": "Updated Author",
  "isbn": "1234567890",
  "publishYear": 2023,
  "quantity": 5
}
```

- **Example Response:**

```json
{
  "id": 1,
  "title": "Updated Book",
  "author": "Updated Author",
  "isbn": "1234567890",
  "publishYear": 2023,
  "quantity": 5
}
```

### Delete a Book

- **URL:** `/api/books/{id}`
- **Method:** `DELETE`
- **Description:** Deletes a book by its ID.
- **Path Parameters:**
    - `id` (Long): The ID of the book to delete.
- **Response:**
    - **Status Code:** `204 No Content`
- **Example Request:**

```http
DELETE /api/books/1 HTTP/1.1
```

- **Example Response:**

```http
204 No Content
```

---

## Patron API Documentation

### Get All Patrons

- **URL:** `/api/patrons`
- **Method:** `GET`
- **Description:** Retrieves a list of all patrons in the library.
- **Response:**
    - **Status Code:** `200 OK`
    - **Body:** JSON array of patron objects.
- **Example Request:**

```http
GET /api/patrons
```

- **Example Response:**

```json
[
  {
    "id": 1,
    "name": "Test Patron",
    "email": "test@gmail.com",
    "phoneNumber": "+1234567890"
  }
]
```

### Get Patron by ID

- **URL:** `/api/patrons/{id}`
- **Method:** `GET`
- **Description:** Retrieves a patron by their ID.
- **Path Parameters:**
    - `id` (Long): The ID of the patron to retrieve.
- **Response:**
    - **Status Code:** `200 OK`
    - **Body:** JSON object of the patron.
- **Example Request:**

```http
GET /api/patrons/1
```

- **Example Response:**

```json
{
  "id": 1,
  "name": "Test Patron",
  "email": "test@gmail.com",
  "phoneNumber": "+1234567890"
}
```

### Create a New Patron

- **URL:** `/api/patrons`
- **Method:** `POST`
- **Description:** Adds a new patron to the library.
- **Request Body:** JSON object representing the patron to be created.
- **Response:**
    - **Status Code:** `201 Created`
    - **Body:** JSON object of the created patron.
- **Example Request:**

```http
POST /api/patrons HTTP/1.1
Content-Type: application/json

{
  "name": "Test Patron",
  "email": "test@gmail.com"
}
```

- **Example Response:**

```json
{
  "id": 1,
  "name": "Test Patron",
  "email": "test@gmail.com",
  "phoneNumber": "+1234567890"
}
```

### Update a Patron

- **URL:** `/api/patrons/{id}`
- **Method:** `PUT`
- **Description:** Updates the details of an existing patron by their ID.
- **Path Parameters:**
    - `id` (Long): The ID of the patron to update.
- **Request Body:** JSON object representing the updated patron details.
- **Response:**
    - **Status Code:** `200 OK`
    - **Body:** JSON object of the updated patron.
- **Example Request:**

```http
PUT /api/patrons/1 HTTP/1.1
Content-Type: application/json

{
  "name": "Updated Patron",
  "email": "updated@gmail.com",
    "phoneNumber": "+1234567890"
}
```

- **Example Response:**

```json
{
  "id": 1,
  "name": "Updated Patron",
  "email": "updated@gmail.com",
  "phoneNumber": "+1234567890"
}
```

### Delete a Patron

- **URL:** `/api/patrons/{id}`
- **Method:** `DELETE`
- **Description:** Deletes a patron by their ID.
- **Path Parameters:**
    - `id` (Long): The ID of the patron to delete.
- **Response:**
    - **Status Code:** `204 No Content`
- **Example Request:**

```http
DELETE /api/patrons/1 HTTP/1.1
```

- **Example Response:**

```http
204 No Content
```

---

## Loan API Documentation

### Borrow a Book

- **URL:** `/api/borrow/{bookId}/patron/{patronId}`
- **Method:** `POST`
- **Description:** Loans a book to a patron.
- **Path Parameters:**
    - `bookId` (Long): The ID of the book to be borrowed.
    - `patronId` (Long): The ID of the patron borrowing the book.
- **Response:**
    - **Status Code:** `201 Created`
    - **Body:** JSON object of the loan.
- **Example Request:**

```http
POST /api/borrow/1/patron/1
```

- **Example Response:**

```json
{
  "id": 1,
  "bookId": 1,
  "patronId": 1,
  "loanDate": "2023-10-01",
  "dueDate": "2023-10-15",
  "returnDate": null
}
```

### Return a Book

- **URL:** `/api/return/{bookId}/patron/{patronId}`
- **Method:** `PUT`
- **Description:** Returns a borrowed book from a patron.
- **Path Parameters:**
    - `bookId` (Long): The ID of the book to be returned.
    - `patronId` (Long): The ID of the patron returning the book.
- **Response:**
    - **Status Code:** `200 OK`
    - **Body:** JSON object of the loan.
- **Example Request:**

```http
PUT /api/return/1/patron/1
```

- **Example Response:**

```json
{
  "id": 1,
  "bookId": 1,
  "patronId": 1,
  "loanDate": "2023-10-01",
  "dueDate": "2023-10-15",
  "returnDate": "2023-10-10"
}
```