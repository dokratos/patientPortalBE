package com.example.demo.patient.repository;

import com.example.demo.patient.model.Patient;
import com.example.demo.patient.model.PatientRequestDTO;
import com.example.demo.patient.model.PatientResponseDTO;
import com.example.demo.patient.model.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PatientRepository {
    JpaRepo repo;

    public PatientRepository(@Autowired JpaRepo repo) { this.repo = repo; }

    public List<PatientResponseDTO> findAllPatients() {
        return Streamable.of(repo.findAll())
                .map(PatientMapper::patientDTOMapper)
                .toList();
    }

    public PatientResponseDTO savePatient(PatientRequestDTO patient) {
        Patient newPatient = repo.save(new Patient(patient.name(),
                patient.lastName(),
                patient.INR()));
        return PatientMapper.patientDTOMapper(newPatient);
    }

    public PatientResponseDTO findPatientById(long id) {
        Patient patient = repo.findById(id).orElse(null);
        return PatientMapper.patientDTOMapper(patient);
    }

    public void deletePatientById(long id) {
        if (findPatientById(id) != null) {
            repo.deleteById(id);
        }
    }
}
