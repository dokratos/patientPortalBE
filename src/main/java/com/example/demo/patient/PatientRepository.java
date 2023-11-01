package com.example.demo.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientRepository {
    JpaRepo repo;

    public PatientRepository(@Autowired JpaRepo repo) { this.repo = repo; }

    public List<Patient> findAllPatients() { return Streamable.of(repo.findAll()).toList(); }

    public Patient savePatient(Patient patient) { return repo.save(patient); }

    public Patient findPatientById(long id) { return repo.findById(id).orElse(null); }

    public void deletePatientById(long id) {
        if (findPatientById(id) != null) {
            repo.deleteById(id);
        }
    }
}
