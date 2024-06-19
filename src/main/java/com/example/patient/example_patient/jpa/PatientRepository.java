package com.example.patient.example_patient.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.patient.example_patient.Patient;

public interface PatientRepository extends JpaRepository<Patient,Integer> {

}
