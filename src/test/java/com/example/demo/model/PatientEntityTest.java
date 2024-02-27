package com.example.demo.model;

import com.example.demo.patient.model.Patient;
import jakarta.persistence.PersistenceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class PatientEntityTest {
    @Autowired
    private TestEntityManager testEntityManager;

    private Patient patientEntity;
    private Patient duplicatePatient;

    @BeforeEach
    void setup() {
        patientEntity = new Patient();
        patientEntity.setName("John");
        patientEntity.setLastName("Doe");
        patientEntity.setINR(2.0);
        duplicatePatient = new Patient();
        duplicatePatient.setName("Viktor");
        duplicatePatient.setLastName("Kadishev");
        duplicatePatient.setINR(0.2);
    }

    @Test
    void testPatientEntity_whenCorrectDataIsProvided_shouldPersistPatient() {
        Patient john = testEntityManager.persistAndFlush(patientEntity);

        Assertions.assertTrue(john.getId() != null, "Patient should have ID");
        Assertions.assertEquals(patientEntity.getName(), john.getName(), () -> "Name does not match");
        Assertions.assertEquals(patientEntity.getLastName(), john.getLastName(), () -> "Surname does not match");
        Assertions.assertEquals(patientEntity.getINR(), john.getINR(), () -> "INR value does not match");
    }

    @Test
    void testPatientEntity_whenIdExists_throwsException() {
        patientEntity.setId(1L);
        duplicatePatient.setId(1L);

        Assertions.assertThrows(PersistenceException.class, () -> {
            testEntityManager.persistAndFlush(duplicatePatient);
        }, "should throw exception!");

    }
}
