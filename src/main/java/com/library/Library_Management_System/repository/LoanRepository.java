package com.library.Library_Management_System.repository;

import com.library.Library_Management_System.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    Optional<Loan> findByBookId(Long bookId);

    Optional<Loan> findLoanByBookIdAndPatronId(Long bookId, Long patronId);
}
