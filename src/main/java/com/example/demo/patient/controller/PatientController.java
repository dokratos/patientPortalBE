package com.example.demo.patient.controller;

import com.example.demo.patient.model.NewPatientDTO;
import com.example.demo.patient.model.PatientDTO;
import com.example.demo.patient.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import java.util.List;

@RestController
@RequestMapping(value = "/patients", produces = MediaType.APPLICATION_JSON_VALUE)
public class PatientController {

    PatientService service;

    public PatientController(@Autowired PatientService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(description = "get all patients", summary = "returns a list of all patients")
    private ResponseEntity<List<PatientDTO>> getPatients() {

        return ResponseEntity.ok(service.findAllPatient());
    }

    @GetMapping("/{id}")
    @Operation(description = "get one patient", summary = "returns one patient by id")
    private ResponseEntity<PatientDTO> getPatientById(@PathVariable long id) {
        try {
            PatientDTO onePatient = service.getOnePatient(id).orElseThrow(() -> new NotFoundException("Patient not found"));
            return ResponseEntity.ok(onePatient);
        } catch (NotFoundException ex) {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    private ResponseEntity<PatientDTO> addPatient(@RequestBody NewPatientDTO newPatient) {
        PatientDTO patient = service.addNewPatient(newPatient);

        return ResponseEntity
                .accepted()
                .body(patient);
    }

    @DeleteMapping(path = "/{id}")
    private ResponseEntity<Void> deletePatientById(@PathVariable long id) {
        service.deletePatient(id);

        return ResponseEntity
                .noContent()
                .build();
    }

    @PutMapping()
    private ResponseEntity<PatientDTO> updatePatient(@RequestBody PatientDTO patient) {
        try {
           PatientDTO updatedPatient = service.updatePatient(patient);
           return ResponseEntity.ok(updatedPatient);
        } catch (NotFoundException ex) {
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }
}
