package com.library.Library_Management_System.controller;

import com.library.Library_Management_System.model.Loan;
import com.library.Library_Management_System.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrow")
public class LoanController {
    @Autowired
    private LoanService loanService;

    // Loan a book to a patron
    @PostMapping("/{bookId}/patron/{patronId}")
    public ResponseEntity<Loan> borrowBook(@PathVariable Long patronId, @PathVariable Long bookId) {
        Loan loan = loanService.loanBook(patronId, bookId);
        return ResponseEntity.status(201).body(loan);
    }

    // Return a book from a patron
    @PutMapping("/{bookId}/patron/{patronId}")
    public ResponseEntity<Loan> returnBook(@PathVariable Long patronId, @PathVariable Long bookId) {
        Loan loan = loanService.returnBook(patronId, bookId);
        return ResponseEntity.ok(loan);
    }
}
