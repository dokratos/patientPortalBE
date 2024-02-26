package com.example.demo.patient.repository;
import com.example.demo.patient.model.Patient;
import org.springframework.data.repository.CrudRepository;

public interface JpaRepo extends CrudRepository<Patient, Long> {

}
