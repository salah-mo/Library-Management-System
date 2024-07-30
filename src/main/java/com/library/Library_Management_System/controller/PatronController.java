package com.library.Library_Management_System.controller;

import com.library.Library_Management_System.model.Patron;
import com.library.Library_Management_System.service.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Patron getPatronById(@PathVariable Long id) {
        return patronService.getPatronById(id);
    }

    // Add a new Patron to the library
    @PostMapping
    public Patron createPatron(@RequestBody Patron patron) {
        patron.setId(null);
        return patronService.createPatron(patron);
    }

    // Update a Patron's details by its ID
    @PutMapping("/{id}")
    public Patron updatePatron(@PathVariable Long id, @RequestBody Patron patronDetails) {
        return patronService.updatePatron(id, patronDetails);
    }

    // Delete a Patron by its ID
    @DeleteMapping("/{id}")
    public void deletePatron(@PathVariable Long id) {
        patronService.deletePatron(id);
    }
}
