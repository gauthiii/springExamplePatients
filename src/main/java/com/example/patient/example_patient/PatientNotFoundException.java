package com.example.patient.example_patient;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PatientNotFoundException extends RuntimeException {

    public PatientNotFoundException(String message) {
		super(message);
        System.out.println("**********************");
        System.out.println("Error Message: "+message);
        System.out.println("**********************");
	}

}
