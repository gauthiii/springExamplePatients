package com.example.patient.example_patient;

import java.net.URI;
import java.util.List;
import java.util.Optional;

// import org.springframework.hateoas.EntityModel;
// import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

// import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class PatientJpaResource {

  
     private PatientRepository repository;

	public PatientJpaResource(PatientRepository repository) {
		this.repository = repository;
	}

	// GET /jpa/patients
	@GetMapping("/jpa/patients")
	public List<Patient> retrieveAllPatients() {
		return repository.findAll();
	}

	// GET /jpa/patients
	@GetMapping("/jpa/patients/{id}")
	public Optional<Patient> retrievePatient(@PathVariable int id) {
        Optional<Patient> patient = repository.findById(id);
        
		
		if(patient.isEmpty())
			throw new PatientNotFoundException("Patient not found with ID: "+id);
		
		return patient;
	}

	// @GetMapping("/jpa/patientsx/{id}")
	// public EntityModel<Patient> retrieveUser(@PathVariable int id) {
	// 	Patient patient = service.findOne(id);
		
	// 	if(patient==null)
	// 		throw new PatientNotFoundException("id:"+id);
		
	// 	EntityModel<Patient> entityModel = EntityModel.of(patient);
		
	// 	WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).retrieveAllPatients());
	// 	entityModel.add(link.withRel("all-patients"));
		
	// 	return entityModel;
	// }

    //POST /jpa/patients
    @PostMapping("/jpa/patients")
	public ResponseEntity<Patient> createUser(@Valid @RequestBody Patient patient) {
		
		Patient savedPatient = repository.save(patient);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedPatient.getId())
						.toUri();   
		
		return ResponseEntity.created(location).build();
	}


    //DELETE /jpa/patients
	@DeleteMapping("/jpa/patients/{id}")
	public void deletePatient(@PathVariable int id) {
		repository.deleteById(id);
	}


}
