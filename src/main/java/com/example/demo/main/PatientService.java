package com.example.demo.main;

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

    public Patient getOnePatient(long id) { return patientRepository.findPatientById(id); }

    public void deletePatient(long id) { patientRepository.deletePatientById(id); }
}
