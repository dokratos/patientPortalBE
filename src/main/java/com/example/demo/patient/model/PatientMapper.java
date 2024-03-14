package com.example.demo.patient.model;

public class PatientMapper {

    public static PatientDTO patientDTOMapper(Patient patient) {
        return new PatientDTO(
                patient.getId(),
                patient.getName(),
                patient.getLastName(),
                patient.getINR());
    }
}
