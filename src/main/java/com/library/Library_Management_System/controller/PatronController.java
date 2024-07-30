package com.library.Library_Management_System.controller;

import com.library.Library_Management_System.model.Patron;
import com.library.Library_Management_System.service.PatronService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patrons")
public class PatronController {

    @Autowired
    private PatronService patronService;

    // Get all Patrons
    @GetMapping()
    public List<Patron> getAllPatrons() {
        return patronService.getAllPatrons();
    }

    // Get a Patron by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Patron> getPatronById(@PathVariable Long id) {
        Patron patron = patronService.getPatronById(id);
        return ResponseEntity.ok(patron);
    }

    // Add a new Patron to the library
    @PostMapping
    public ResponseEntity<Patron> createPatron(@Valid @RequestBody Patron patron) {
        Patron createdPatron = patronService.createPatron(patron);
        return ResponseEntity.status(201).body(createdPatron);
    }

    // Update a Patron's details by its ID
    @PutMapping("/{id}")
    public ResponseEntity<Patron> updatePatron(@PathVariable Long id, @Valid @RequestBody Patron patronDetails) {
        Patron updatedPatron = patronService.updatePatron(id, patronDetails);
        return ResponseEntity.ok(updatedPatron);
    }

    // Delete a Patron by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatron(@PathVariable Long id) {
        patronService.deletePatron(id);
        return ResponseEntity.noContent().build();
    }
}
