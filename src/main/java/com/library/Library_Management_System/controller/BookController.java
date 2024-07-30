package com.library.Library_Management_System.controller;

import com.library.Library_Management_System.model.Book;
import com.library.Library_Management_System.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    // Get all Books
    @GetMapping()
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // Get a Book by its ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    // Add a new Book to the library
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        book.setId(null);
        return bookService.createBook(book);
    }

    // Update a Book's details by its ID
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        return bookService.updateBook(id, bookDetails);
    }

    // Delete a Book by its ID
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}