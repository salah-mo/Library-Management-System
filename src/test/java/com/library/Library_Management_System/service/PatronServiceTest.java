package com.library.Library_Management_System.service;

import com.library.Library_Management_System.model.Patron;
import com.library.Library_Management_System.repository.PatronRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PatronServiceTest {

    @Mock
    private PatronRepository patronRepository;

    @InjectMocks
    private PatronService patronService;

    private Patron patron;

    @BeforeEach
    void setUp() {
        patron = new Patron();
        patron.setId(4L);
        patron.setName("Salah");
        patron.setEmail("salah.mo@gmail.com");
        patron.setPhoneNumber(1234567890);
    }

    @Test
    void testGetPatronById() {
        when(patronRepository.findById(4L)).thenReturn(Optional.of(patron));
        Patron found = patronService.getPatronById(4L);
        assertEquals(patron, found);
    }

    @Test
    void testGetPatronByIdNotFound() {
        when(patronRepository.findById(4L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> patronService.getPatronById(4L));
    }

    @Test
    void testCreatePatron() {
        when(patronRepository.save(patron)).thenReturn(patron);
        Patron saved = patronService.createPatron(patron);
        assertEquals(patron, saved);
    }

    @Test
    void testUpdatePatron() {
        when(patronRepository.findById(4L)).thenReturn(Optional.of(patron));
        when(patronRepository.save(patron)).thenReturn(patron);
        Patron updated = patronService.updatePatron(4L, patron);
        assertEquals(patron, updated);
    }
    
    @Test
    void testUpdatePatronNotFound() {
        when(patronRepository.findById(4L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> patronService.updatePatron(4L, patron));
    }

    @Test
    void testDeletePatron() {
        when(patronRepository.findById(1L)).thenReturn(Optional.of(patron));
        doNothing().when(patronRepository).delete(patron);
        patronService.deletePatron(1L);
        verify(patronRepository, times(1)).delete(patron);
    }
}
