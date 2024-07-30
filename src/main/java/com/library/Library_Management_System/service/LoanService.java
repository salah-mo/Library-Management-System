package com.library.Library_Management_System.service;

import com.library.Library_Management_System.model.Book;
import com.library.Library_Management_System.model.Loan;
import com.library.Library_Management_System.model.Patron;
import com.library.Library_Management_System.repository.BookRepository;
import com.library.Library_Management_System.repository.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import com.library.Library_Management_System.repository.LoanRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PatronRepository patronRepository;

    @Transactional
    public Loan loanBook(Long bookId, Long patronId) {
        Book book = bookRepository.findBookById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        Patron patron = patronRepository.findPatronById(patronId).orElseThrow(() -> new ResourceNotFoundException("Patron not found"));

        Loan loan = new Loan();
        loan.setBook(book);
        loan.setPatron(patron);
        loan.setLoanDate(LocalDate.now());
        return loanRepository.save(loan);
    }

    @Transactional
    public Loan returnBook(Long bookId, Long patronId) {
        Loan loan = loanRepository.findLoanByBookIdAndPatronId(bookId, patronId).orElseThrow(() -> new ResourceNotFoundException("Loan not found"));
        loan.setReturnDate(LocalDate.now());
        return loanRepository.save(loan);
    }

}
