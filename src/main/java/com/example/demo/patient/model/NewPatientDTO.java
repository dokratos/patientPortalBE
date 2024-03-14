package com.example.demo.patient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public record NewPatientDTO(String name,
                            String lastName,
                            double INR) {
}
