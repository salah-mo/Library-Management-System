package com.library.Library_Management_System.controller;

import com.library.Library_Management_System.exception.GlobalExceptionHandler;
import com.library.Library_Management_System.model.Loan;
import com.library.Library_Management_System.service.LoanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class LoanControllerTest {

    private MockMvc mockMvc;

    @Mock
    private LoanService borrowingService;

    @InjectMocks
    private LoanController borrowingController;

    private Loan loan;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(borrowingController)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
        loan = new Loan();
    }

    @Test
    public void testBorrowBook() throws Exception {
        when(borrowingService.loanBook(1L, 1L)).thenReturn(loan);

        mockMvc.perform(post("/api/borrow/1/patron/1"))
                .andExpect(status().isCreated());
    }

    @Test
    public void testReturnBook() throws Exception {
        when(borrowingService.returnBook(1L, 1L)).thenReturn(loan);

        mockMvc.perform(put("/api/return/1/patron/1"))
                .andExpect(status().isOk());
    }
}
