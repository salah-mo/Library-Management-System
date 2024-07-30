package com.library.Library_Management_System.controller;

import com.library.Library_Management_System.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrow")
public class LoanController {
    @Autowired
    private LoanService loanService;

    // Loan a book to a patron
    @PostMapping("/{bookId}/patron/{patronId}")
    public void loanBook(@PathVariable Long patronId, @PathVariable Long bookId) {
        loanService.loanBook(patronId, bookId);
    }

    // Return a book from a patron
    @PutMapping("/{bookId}/patron/{patronId}")
    public void returnBook(@PathVariable Long patronId, @PathVariable Long bookId) {
        loanService.returnBook(patronId, bookId);
    }
}
