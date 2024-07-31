package com.library.Library_Management_System.service;

import com.library.Library_Management_System.model.Book;
import com.library.Library_Management_System.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    private Book book;

    @BeforeEach
    public void setUp() {
        book = new Book();
        book.setId(1L);
        book.setTitle("Design Data-Intensive Applications");
        book.setAuthor("Martin Kleppmann");
        book.setIsbn("9781449373320");
        book.setPublishYear(2017);
        book.setQuantity(5);
    }

    @Test
    public void testGetBookById() {
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        Book found = bookService.getBookById(1L);
        assertEquals(book, found);
    }

    @Test
    public void testGetBookByIdNotFound() {
        when(bookRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> bookService.getBookById(1L));
    }

    @Test
    public void testCreateBook() {
        when(bookRepository.save(book)).thenReturn(book);
        Book created = bookService.createBook(book);
        assertEquals(book, created);
    }

    @Test
    public void testUpdateBook() {
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        when(bookRepository.save(book)).thenReturn(book);
        Book updatedBook = bookService.updateBook(1L, book);
        assertEquals(updatedBook, updatedBook);
    }

    @Test
    public void testUpdateBookNotFound() {
        when(bookRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> bookService.updateBook(1L, book));
    }

    @Test
    public void testDeleteBook() {
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        bookService.deleteBook(1L);
    }
}