package com.example.demo.repository;

import com.example.demo.patient.model.Patient;
import com.example.demo.patient.model.PatientResponseDTO;
import com.example.demo.patient.repository.PatientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

@DataJpaTest
public class PatientRepositoryTest {
    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    PatientRepository repository;

    private Patient patientEntity;
    private Patient secondPatient;
    private Patient duplicateEntity;

    @BeforeEach
    void setup() {
        patientEntity = new Patient();
        patientEntity.setId(1L);
        patientEntity.setName("John");
        patientEntity.setLastName("Doe");
        patientEntity.setINR(2.0);
        testEntityManager.persistAndFlush(patientEntity);

        secondPatient = new Patient();
        secondPatient.setName("Diego");
        secondPatient.setLastName("Caferati");
        secondPatient.setINR(0.2);
        testEntityManager.persistAndFlush(secondPatient);

        duplicateEntity = new Patient();
    }

    @Test
    void testFindAllPatients_returnsAllPatients() {
        List<PatientResponseDTO> patientList = repository.findAllPatients();

        Assertions.assertTrue(patientList.size() == 2, () -> "There should be 2 patients in the list");
    }


}
