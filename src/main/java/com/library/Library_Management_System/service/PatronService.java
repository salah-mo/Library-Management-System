package com.library.Library_Management_System.service;

import com.library.Library_Management_System.model.Patron;
import com.library.Library_Management_System.repository.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatronService {
    @Autowired
    private PatronRepository patronRepository;

    public List<Patron> getAllPatrons() {
        return patronRepository.findAll();
    }

    public Patron getPatronById(Long id) {
        return patronRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patron not found"));
    }

    @Transactional
    public Patron createPatron(Patron patron) {
        return patronRepository.save(patron);
    }

    @Transactional
    public Patron updatePatron(Long id, Patron patronDetails) {
        Patron patron = getPatronById(id);
        patron.setName(patronDetails.getName());
        patron.setEmail(patronDetails.getEmail());
        patron.setPhoneNumber(patronDetails.getPhoneNumber());
        return patronRepository.save(patron);
    }

    @Transactional
    public void deletePatron(Long id) {
        Patron patron = getPatronById(id);
        patronRepository.delete(patron);
    }
}
