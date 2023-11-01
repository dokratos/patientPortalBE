package com.example.demo.patient;

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

    @GetMapping("/")
    private String getRequest() {
        return "We are online!";
    }

    @GetMapping("/patients")
    private ResponseEntity<List<Patient>> getPatients() {
        return ResponseEntity.ok(service.findAllPatient());
    }

    @PostMapping("/patients")
    private ResponseEntity<Patient> addPatient(@RequestBody ) {

    }
}
