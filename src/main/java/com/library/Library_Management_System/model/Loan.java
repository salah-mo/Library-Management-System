package com.library.Library_Management_System.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;


@Entity
public class Loan {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "patron_id", nullable = false)
    private Patron patron;

    private LocalDate loanDate;

    private LocalDate returnDate;

    @AssertTrue(message = "Return date should be after loan date")
    public boolean isReturnDateValid() {
        return returnDate == null || returnDate.isAfter(loanDate) || returnDate.isEqual(loanDate);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Patron getPatron() {
        return patron;
    }

    public void setPatron(Patron patron) {
        this.patron = patron;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }
}
