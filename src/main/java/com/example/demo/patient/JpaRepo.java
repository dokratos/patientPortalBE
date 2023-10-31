package com.example.demo.patient;
import org.springframework.data.repository.CrudRepository;

public interface JpaRepo extends CrudRepository<Patient, Long> {

}
