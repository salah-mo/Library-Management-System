package com.library.Library_Management_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.library.Library_Management_System.model.Patron;

import java.util.Optional;


public interface PatronRepository extends JpaRepository<Patron, Long> {
    Optional<Patron> findPatronById(Long id);

    Optional<Patron> findPatronByName(String name);

    Optional<Patron> findPatronByEmail(String email);
}
