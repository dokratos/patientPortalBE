package com.example.demo.patient.service;

import com.example.demo.patient.model.NewPatientDTO;
import com.example.demo.patient.model.PatientDTO;
import com.example.demo.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    PatientRepository patientRepository;

    public PatientService(@Autowired PatientRepository repo) {
        this.patientRepository = repo;
    }

    public List<PatientDTO> findAllPatient() {
        return patientRepository.findAllPatients();
    }

    public PatientDTO addNewPatient(NewPatientDTO patient) {
        return patientRepository.savePatient(patient);
    }

    public Optional<PatientDTO> getOnePatient(long id) {
        return patientRepository.findPatientById(id);
    }

    public void deletePatient(long id) { patientRepository.deletePatientById(id); }

    public PatientDTO updatePatient(PatientDTO patient) {

        PatientDTO updatedPatient = patientRepository.updatePatient(patient);

        if (updatedPatient == null) {
            throw new NotFoundException("Patient was not found");
        }

        return updatedPatient;
    }
}
