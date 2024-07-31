package com.library.Library_Management_System.controller;

import com.library.Library_Management_System.model.Book;
import com.library.Library_Management_System.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

 class BookControllerTest {

    private MockMvc mockMvc;

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    private Book book;

    @BeforeEach
     void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
        book = new Book();
        book.setId(1L);
        book.setTitle("Test Book");
        book.setAuthor("Test Author");
        book.setIsbn("1234567890");
        book.setPublishYear(2023);
        book.setQuantity(5);

    }

    @Test
     void testGetAllBooks() throws Exception {
        when(bookService.getAllBooks()).thenReturn(Collections.singletonList(book));

        mockMvc.perform(get("/api/books")).andExpect(status().isOk()).andExpect(jsonPath("$[0].title").value("Test Book"));
    }

    @Test
    void testGetBookById() throws Exception {
        when(bookService.getBookById(1L)).thenReturn(book);

        mockMvc.perform(get("/api/books/1")).andExpect(status().isOk()).andExpect(jsonPath("$.title").value("Test Book"));
    }

    @Test
     void testCreateBook() throws Exception {
        when(bookService.createBook(any(Book.class))).thenReturn(book);

        mockMvc.perform(post("/api/books").contentType(MediaType.APPLICATION_JSON).content("{\"title\":\"Test Book\",\"author\":\"Test Author\",\"isbn\":\"1234567890\",\"publishYear\":2023,\"quantity\":5}")).andExpect(status().isCreated()).andExpect(jsonPath("$.title").value("Test Book"));
    }

    @Test
     void testUpdateBook() throws Exception {
        when(bookService.updateBook(eq(1L), any(Book.class))).thenReturn(book);

        mockMvc.perform(put("/api/books/1").contentType(MediaType.APPLICATION_JSON).content("{\"title\":\"Updated Book\",\"author\":\"Updated Author\",\"isbn\":\"1234567890\",\"publishYear\":2023,\"quantity\":5}")).andExpect(status().isOk()).andExpect(jsonPath("$.title").value("Test Book"));
    }

    @Test
     void testDeleteBook() throws Exception {
        doNothing().when(bookService).deleteBook(1L);

        mockMvc.perform(delete("/api/books/1")).andExpect(status().isNoContent());
    }
}