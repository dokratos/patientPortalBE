package com.example.demo.patient.model;

public record PatientResponseDTO(
                         Long id,
                         String name,
                         String lastName,
                         double INR) {
}
