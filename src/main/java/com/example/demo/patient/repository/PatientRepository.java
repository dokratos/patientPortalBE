package com.example.demo.patient.repository;

import com.example.demo.patient.model.Patient;
import com.example.demo.patient.model.NewPatientDTO;
import com.example.demo.patient.model.PatientDTO;
import com.example.demo.patient.model.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Repository
public class PatientRepository {
    JpaRepo repo;

    public PatientRepository(@Autowired JpaRepo repo) { this.repo = repo; }

    public List<PatientDTO> findAllPatients() {
        return Streamable.of(repo.findAll())
                .map(PatientMapper::patientDTOMapper)
                .toList();
    }

    public PatientDTO savePatient(NewPatientDTO patient) {
        Patient newPatient = repo.save(new Patient(patient.name(),
                patient.lastName(),
                patient.INR()));
        return PatientMapper.patientDTOMapper(newPatient);
    }

    public Optional<PatientDTO> findPatientById(long id) {
        Patient patient = repo.findById(id).orElse(null);
        return Optional.of(PatientMapper.patientDTOMapper(patient));
    }

    public void deletePatientById(long id) {
        if (findPatientById(id).isPresent()) {
            repo.deleteById(id);
        } else {
            throw new NotFoundException("Patient with id " + id + " was not found");
        }
    }

    public PatientDTO updatePatient(PatientDTO patient) {
        Optional<Patient> patientToUpdate = repo.findById(patient.id());

        if (patientToUpdate.isPresent()) {
            Patient updatedPatient = patientToUpdate.get();
            updatedPatient.setName(patient.name());
            updatedPatient.setLastName(patient.lastName());
            updatedPatient.setINR(patient.INR());

            updatedPatient = repo.save(updatedPatient);
            return PatientMapper.patientDTOMapper(updatedPatient);
        }
        return null;
    }


}
