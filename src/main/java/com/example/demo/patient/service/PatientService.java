package com.example.demo.patient.service;

import com.example.demo.patient.model.Patient;
import com.example.demo.patient.model.PatientRequestDTO;
import com.example.demo.patient.model.PatientResponseDTO;
import com.example.demo.patient.model.PatientMapper;
import com.example.demo.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    PatientRepository patientRepository;

    public PatientService(@Autowired PatientRepository repo) {
        this.patientRepository = repo;
    }

    public List<PatientResponseDTO> findAllPatient() {
        return patientRepository.findAllPatients();
    }

    public PatientResponseDTO addNewPatient(PatientRequestDTO patient) {
        return patientRepository.savePatient(patient);
    }

    public PatientResponseDTO getOnePatient(long id) {
        return patientRepository.findPatientById(id);
    }

    public void deletePatient(long id) { patientRepository.deletePatientById(id); }

//    public PatientResponseDTO updatePatient(PatientResponseDTO patient) {
//
//    }
}
