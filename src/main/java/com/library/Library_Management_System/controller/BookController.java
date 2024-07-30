package com.library.Library_Management_System.controller;

import com.library.Library_Management_System.model.Book;
import com.library.Library_Management_System.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@Validated
public class BookController {
    @Autowired
    private BookService bookService;

    // Get all Books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // Get a Book by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    // Add a new Book to the library
    @PostMapping
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) {
        Book createdBook = bookService.createBook(book);
        return ResponseEntity.status(201).body(createdBook);
    }

    // Update a Book's details by its ID

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @Valid @RequestBody Book bookDetails) {
        Book updatedBook = bookService.updateBook(id, bookDetails);
        return ResponseEntity.ok(updatedBook);
    }

    // Delete a Book by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}