package com.example.demo.patient.model;

public class PatientMapper {

    public static PatientResponseDTO patientDTOMapper(Patient patient) {
        return new PatientResponseDTO(
                patient.getId(),
                patient.getName(),
                patient.getLastName(),
                patient.getINR());
    }
}
