package com.example.patient.example_patient;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.patient.example_patient.jpa.PatientRepository;

import jakarta.validation.Valid;

@RestController
public class PatientJpaResource {

 

	 private PatientRepository repository;

	public PatientJpaResource(PatientRepository repository) {
		 
		this.repository = repository;
	}

	// GET /patients
	@GetMapping("/jpa/patients")
	public List<Patient> retrieveAllPatients() {
		return repository.findAll();
	}

	// GET /patients
	@GetMapping("/jpa/patients/{id}")
	public Optional<Patient> retrievePatient(@PathVariable int id) {
        Optional<Patient> patient = repository.findById(id);
        
		
		if(patient.isEmpty())
			throw new PatientNotFoundException("Patient not found with ID: "+id);
		
		return patient;
	}

    //POST /patients
    @PostMapping("/jpa/patients")
	public ResponseEntity<Patient> createUser(@Valid @RequestBody Patient patient) {
		
		Patient savedPatient = repository.save(patient);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedPatient.getId())
						.toUri();   
		
		return ResponseEntity.created(location).build();
	}


    //DELETE /patients
	@DeleteMapping("/jpa/patients/{id}")
	public void deletePatient(@PathVariable int id) {
		repository.deleteById(id);
	}

}
