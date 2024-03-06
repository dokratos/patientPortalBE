package com.example.demo.patient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public record PatientRequestDTO(String name,
                                String lastName,
                                double INR) {
}
