package com.example.demo.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    PatientRepository patientRepository;

    public PatientService(@Autowired PatientRepository repo) {
        this.patientRepository = repo;
    }

    public List<Patient> findAllPatient() {
        return patientRepository.findAllPatients();
    }

    public Patient addNewPatient(Patient patient) {
        return patientRepository.savePatient(patient);
    }
}
