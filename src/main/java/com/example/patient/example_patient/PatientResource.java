package com.example.patient.example_patient;

import java.net.URI;
import java.util.List;

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
public class PatientResource {


     private PatientDaoService service;

	public PatientResource(PatientDaoService service) {
		this.service = service;
	}

	// GET /patients
	@GetMapping("/patients")
	public List<Patient> retrieveAllPatients() {
		return service.findAll();
	}

	// GET /patients
	@GetMapping("/patients/{id}")
	public Patient retrievePatient(@PathVariable int id) {
        Patient patient = service.findOne(id);
        
		
		if(patient==null)
			throw new PatientNotFoundException("Patient not found with ID: "+id);
		
		return patient;
	}

	// @GetMapping("/patientsx/{id}")
	// public EntityModel<Patient> retrieveUser(@PathVariable int id) {
	// 	Patient patient = service.findOne(id);
		
	// 	if(patient==null)
	// 		throw new PatientNotFoundException("id:"+id);
		
	// 	EntityModel<Patient> entityModel = EntityModel.of(patient);
		
	// 	WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).retrieveAllPatients());
	// 	entityModel.add(link.withRel("all-patients"));
		
	// 	return entityModel;
	// }

    //POST /patients
    @PostMapping("/patients")
	public ResponseEntity<Patient> createUser(@Valid @RequestBody Patient patient) {
		
		Patient savedPatient = service.save(patient);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedPatient.getId())
						.toUri();   
		
		return ResponseEntity.created(location).build();
	}


    //DELETE /patients
	@DeleteMapping("/patients/{id}")
	public void deletePatient(@PathVariable int id) {
		service.deleteById(id);
	}

}
