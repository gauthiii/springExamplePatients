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
        // Ensure patientsCount and patients list are declared and initialized properly
        patients.add(new Patient(++patientsCount, "Gautham", LocalDate.of(1999, 8, 21), "Wheezing", "9840483494",
            "1234 Elm Street", "Male", Arrays.asList("Albuterol"), Arrays.asList("Peanuts"),
            "178 cm", "118 kg", "36.2", "A1+",
            "Asthma", "BlueCross", "BC1234567", "Niveda", "Sister", "9840483494", 
            Arrays.asList(), Arrays.asList(), Arrays.asList()));
    
        patients.add(new Patient(++patientsCount, "Mira", LocalDate.of(1987, 3, 14), "None", "9550550123",
            "567 Oak Lane", "Female", Arrays.asList(), Arrays.asList(),
            "165 cm", "54 kg", "19.8", "O+",
            "None", "HealthPlus", "HP2345608", "Rohan", "Brother", "9550550124", 
            Arrays.asList("2023-10-03"), Arrays.asList("Multivitamin"), Arrays.asList()));
    
        patients.add(new Patient(++patientsCount, "Anil", LocalDate.of(1972, 5, 22), "Hypertension", "9234567890",
            "789 Pine Road", "Male", Arrays.asList("Lisinopril"), Arrays.asList("Nuts"),
            "170 cm", "82 kg", "28.4", "B+",
            "High Blood Pressure", "MediCare", "MC3456712", "Anita", "Wife", "9234567891", 
            Arrays.asList("2023-11-15"), Arrays.asList("Lisinopril"), Arrays.asList("Invoice#7892")));
    
        patients.add(new Patient(++patientsCount, "Sophia", LocalDate.of(2001, 12, 25), "Type 1 Diabetes", "9888665544",
            "123 Maple Street", "Female", Arrays.asList("Insulin"), Arrays.asList("Gluten"),
            "162 cm", "60 kg", "22.9", "AB-",
            "Diabetes Mellitus", "CareFirst", "CF4567823", "Max", "Father", "9888665545", 
            Arrays.asList("2023-12-12"), Arrays.asList("Insulin"), Arrays.asList("Invoice#7901", "Invoice#7902")));
    
        patients.add(new Patient(++patientsCount, "Liam", LocalDate.of(1990, 9, 9), "Seasonal Allergies", "9777554466",
            "321 Birch Avenue", "Male", Arrays.asList("Loratadine"), Arrays.asList("Pollen"),
            "175 cm", "75 kg", "24.5", "A-",
            "Allergic Rhinitis", "GlobalHealth", "GH5678934", "Olivia", "Partner", "9777554467", 
            Arrays.asList("2023-09-01"), Arrays.asList("Loratadine"), Arrays.asList()));
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
