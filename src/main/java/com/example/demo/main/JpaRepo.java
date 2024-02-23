package com.example.demo.main;
import org.springframework.data.repository.CrudRepository;

public interface JpaRepo extends CrudRepository<Patient, Long> {

}
