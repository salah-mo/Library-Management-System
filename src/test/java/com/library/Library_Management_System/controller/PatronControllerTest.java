package com.library.Library_Management_System.controller;


import com.library.Library_Management_System.exception.GlobalExceptionHandler;
import com.library.Library_Management_System.model.Patron;
import com.library.Library_Management_System.service.PatronService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class PatronControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PatronService patronService;

    @InjectMocks
    private PatronController patronController;

    private Patron patron;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(patronController)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
        patron = new Patron();
        patron.setId(1L);
        patron.setName("Test Patron");
        patron.setEmail("test@example.com");
        patron.setPhoneNumber("1234567890");
    }

    @Test
    public void testGetAllPatrons() throws Exception {
        when(patronService.getAllPatrons()).thenReturn(Arrays.asList(patron));

        mockMvc.perform(get("/api/patrons"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Test Patron"));
    }

    @Test
    public void testGetPatronById() throws Exception {
        when(patronService.getPatronById(1L)).thenReturn(patron);

        mockMvc.perform(get("/api/patrons/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Test Patron"));
    }

    @Test
    public void testCreatePatron() throws Exception {
        when(patronService.createPatron(any(Patron.class))).thenReturn(patron);

        mockMvc.perform(post("/api/patrons")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Test Patron\",\"email\":\"test@example.com\",\"phoneNumber\":\"1234567890\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Test Patron"));
    }

    @Test
    public void testUpdatePatron() throws Exception {
        when(patronService.updatePatron(eq(1L), any(Patron.class))).thenReturn(patron);

        mockMvc.perform(put("/api/patrons/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Updated Patron\",\"email\":\"updated@example.com\",\"phoneNumber\":\"1234567890\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Test Patron"));
    }

    @Test
    public void testDeletePatron() throws Exception {
        doNothing().when(patronService).deletePatron(1L);

        mockMvc.perform(delete("/api/patrons/1"))
                .andExpect(status().isNoContent());
    }
}
