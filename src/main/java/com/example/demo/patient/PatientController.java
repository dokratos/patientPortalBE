package com.example.demo.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/portal/", produces = MediaType.APPLICATION_JSON_VALUE)
public class PatientController {

    PatientService service;

//    public PatientController(@Autowired PatientService service) {
//        this.service = service;
//    }

    @GetMapping()
    private String getRequest() {
        return "We are online!";
    }
}
