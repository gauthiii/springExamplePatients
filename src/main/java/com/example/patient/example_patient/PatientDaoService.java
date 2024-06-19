package com.example.patient.example_patient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class PatientDaoService {

    private static List<Patient> patients = new ArrayList<>();

    private static int patientsCount = 0;

    static {
        patients.add(new Patient(++patientsCount, "Gautham", LocalDate.of(1999, 8, 21), "Wheezing", "9840483494",
            "1234 Elm Street", "Male", Arrays.asList("Albuterol"), Arrays.asList("Peanuts"), "Asthma",
            "BlueCross", "BC1234567", "Niveda", "Sister", "9840483494",Arrays.asList(),Arrays.asList(),Arrays.asList()));
            
        patients.add(new Patient(++patientsCount, "Anita", LocalDate.of(1995, 5, 15), "Migraines", "9940583494",
        "5678 Maple Drive", "Female", Arrays.asList("Sumatriptan"), Arrays.asList("Gluten"), "Chronic Migraine",
        "UnitedHealth", "UH2345678", "Rajesh Kumar", "Brother", "9940583495",Arrays.asList(),Arrays.asList(),Arrays.asList()));

        patients.add(new Patient(++patientsCount, "Raj", LocalDate.of(1988, 12, 10), "Diabetes", "9040583494",
        "9101 Pine Road", "Male", Arrays.asList("Metformin"), Arrays.asList("None"), "Type 2 Diabetes",
        "Cigna", "CG3456789", "Simran Raj", "Wife", "9040583495",Arrays.asList(),Arrays.asList(),Arrays.asList()));

        patients.add(new Patient(++patientsCount, "Lila", LocalDate.of(2002, 3, 25), "Eczema", "9340583494",
        "3214 Oak Lane", "Female", Arrays.asList("Corticosteroid cream"), Arrays.asList("Dairy"), "Eczema",
        "Aetna", "AT4567890", "Mohit Lila", "Father", "9340583495",Arrays.asList(),Arrays.asList(),Arrays.asList()));
            
        patients.add(new Patient(++patientsCount, "Sam", LocalDate.of(1980, 7, 30), "Hypertension", "9140583494",
        "13245 Birch Avenue", "Male", Arrays.asList("Lisinopril"), Arrays.asList("Shellfish"), "High Blood Pressure",
        "Kaiser", "KP5678901", "Nina Sam", "Mother", "9140583495",Arrays.asList(),Arrays.asList(),Arrays.asList()));

        patients.add(new Patient(++patientsCount, "Diana", LocalDate.of(1975, 9, 19), "No known conditions", "9740583494",
        "7812 Cedar Blvd", "Female", Arrays.asList(), Arrays.asList(), "None",
        "Humana", "HM6789012", "Charles Diana", "Husband", "9740583496",Arrays.asList(),Arrays.asList(),Arrays.asList()));

        patients.add(new Patient(++patientsCount, "Leo", LocalDate.of(1992, 11, 11), "Arthritis", "9840583484",
        "8823 Spruce Street", "Male", Arrays.asList("Ibuprofen"), Arrays.asList("Ibuprofen"), "Rheumatoid Arthritis",
        "BlueCross", "BC2345612", "Sophie Leo", "Sister", "9840583485",Arrays.asList(),Arrays.asList(),Arrays.asList()));

        patients.add(new Patient(++patientsCount, "Tina", LocalDate.of(1990, 10, 5), "Bronchitis", "9940483484",
        "4519 Willow Path", "Female", Arrays.asList("Amoxicillin"), Arrays.asList("Latex"), "Chronic Bronchitis",
        "UnitedHealth", "UH3345613", "Alex Tina", "Brother", "9940483485",Arrays.asList(),Arrays.asList(),Arrays.asList()));
            
        patients.add(new Patient(++patientsCount, "Vikram", LocalDate.of(1984, 4, 20), "Dermatitis", "9840583484",
        "6237 Elm Street", "Male", Arrays.asList("Hydrocortisone"), Arrays.asList("Nickel"), "Contact Dermatitis",
        "Cigna", "CG4356714", "Preeti Vikram", "Wife", "9840583485",Arrays.asList(),Arrays.asList(),Arrays.asList()));

        patients.add(new Patient(++patientsCount, "Isha", LocalDate.of(2001, 1, 1), "Anxiety", "9540483494",
        "1328 Maple Avenue", "Female", Arrays.asList("Escitalopram"), Arrays.asList("None"), "Generalized Anxiety Disorder",
        "Aetna", "AT5367815", "Amit Isha", "Father", "9540483495",Arrays.asList(),Arrays.asList(),Arrays.asList()));

     
    }

    public Patient save(Patient patient) {
		patient.setId(++patientsCount);
		patients.add(patient);
		return patient;
	}

    public List<Patient> findAll(){
        return patients;
    }

    public Patient findOne(int id) {
		Predicate<? super Patient> predicate = patient -> patient.getId().equals(id); 
		return patients.stream().filter(predicate).findFirst().orElse(null);
	}

    public void deleteById(int id) {
		Predicate<? super Patient> predicate = patient -> patient.getId().equals(id);
		patients.removeIf(predicate);
	}

}
