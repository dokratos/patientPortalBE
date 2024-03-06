package com.example.demo.patient.controller;

import com.example.demo.patient.model.PatientRequestDTO;
import com.example.demo.patient.model.PatientResponseDTO;
import com.example.demo.patient.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/portal", produces = MediaType.APPLICATION_JSON_VALUE)
public class PatientController {

    PatientService service;

    public PatientController(@Autowired PatientService service) {
        this.service = service;
    }

    @GetMapping("/patients")
    @Operation(description = "get all patients", summary = "returns a list of all patients")
    private ResponseEntity<List<PatientResponseDTO>> getPatients() {

        return ResponseEntity.ok(service.findAllPatient());
    }

    @GetMapping("/patients/{id}")
    @Operation(description = "get one patient", summary = "returns one patient by id")
    private ResponseEntity<PatientResponseDTO> getPatientById(@PathVariable long id) {
        PatientResponseDTO onePatient = service.getOnePatient(id);

        return ResponseEntity.ok(onePatient);
    }

    @PostMapping(value = "/patients", consumes = {"*/*"})
    private ResponseEntity<PatientResponseDTO> addPatient(@RequestBody PatientRequestDTO newPatient) {
        PatientResponseDTO patient = service.addNewPatient(newPatient);

        return ResponseEntity
                .accepted()
                .body(patient);
    }

    @DeleteMapping(path = "/patients/{id}")
    private ResponseEntity<Void> deletePatientById(@PathVariable long id) {
        service.deletePatient(id);

        return ResponseEntity
                .noContent()
                .build();
    }
}
