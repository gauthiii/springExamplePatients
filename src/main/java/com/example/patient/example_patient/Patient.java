package com.example.patient.example_patient;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
public class Patient {

    protected Patient() {
        
    }

    //Personal Information
    @Id
    @GeneratedValue
    private Integer id;

    @Size(min=2, message = "Name should have atleast 2 characters")
    private String name;

    @Past
    private LocalDate birthDate;
    
    private String contact;
    private String address;
    private String gender;
    //Medical Information
    private String height;
    private String weight;
    private String bmi;
    private String blood;
    private String medicalHistory;
    private List<String> currentMedications;
    private List<String> allergies;
    private String primaryDiagnosis;
    private String insuranceProvider;
    private String insurancePolicyNumber;
    //Emergency Contact
    private String emergencyContactName;
    private String emergencyContactRelation;
    private String emergencyContactPhone;
    //IDS to other DBs
    private List<String> appointments;
    private List<String> prescriptions;
    private List<String> bills;

    // Full constructor
    public Patient(Integer id, String name, LocalDate birthDate, String medicalHistory, String contact,
                   String address, String gender, List<String> currentMedications, List<String> allergies,
                   String height, String weight, String bmi, String blood, 
                   String primaryDiagnosis, String insuranceProvider, String insurancePolicyNumber,
                   String emergencyContactName, String emergencyContactRelation, String emergencyContactPhone,
                   List<String> appointments,List<String> prescriptions,List<String> bills) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.medicalHistory = medicalHistory;
        this.contact = contact;
        this.address = address;
        this.gender = gender;
        this.currentMedications = currentMedications;
        this.allergies = allergies;
        this.height = height;
        this.weight=weight;
        this.bmi=bmi;
        this.blood=blood;
        this.primaryDiagnosis = primaryDiagnosis;
        this.insuranceProvider = insuranceProvider;
        this.insurancePolicyNumber = insurancePolicyNumber;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactRelation = emergencyContactRelation;
        this.emergencyContactPhone = emergencyContactPhone;
        this.appointments = appointments;
        this.prescriptions = prescriptions;
        this.bills = bills;
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
    
    public String getMedicalHistory() { return medicalHistory; }
    public void setMedicalHistory(String medicalHistory) { this.medicalHistory = medicalHistory; }
    
    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
    
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    
    public List<String> getCurrentMedications() { return currentMedications; }
    public void setCurrentMedications(List<String> currentMedications) { this.currentMedications = currentMedications; }
    
    public List<String> getAllergies() { return allergies; }
    public void setAllergies(List<String> allergies) { this.allergies = allergies; }

    public String getHeight() { return height; }
    public void setHeight(String height) { this.height = height; }

    public String getWeight() { return weight; }
    public void setWeight(String weight) { this.weight = weight; }

    public String getBmi() { return bmi; }
    public void setBmi(String bmi) { this.bmi = bmi; }

    public String getBlood() { return blood; }
    public void setBlood(String blood) { this.blood = blood; }

    
    public String getPrimaryDiagnosis() { return primaryDiagnosis; }
    public void setPrimaryDiagnosis(String primaryDiagnosis) { this.primaryDiagnosis = primaryDiagnosis; }
    
    public String getInsuranceProvider() { return insuranceProvider; }
    public void setInsuranceProvider(String insuranceProvider) { this.insuranceProvider = insuranceProvider; }
    
    public String getInsurancePolicyNumber() { return insurancePolicyNumber; }
    public void setInsurancePolicyNumber(String insurancePolicyNumber) { this.insurancePolicyNumber = insurancePolicyNumber; }
    
    public String getEmergencyContactName() { return emergencyContactName; }
    public void setEmergencyContactName(String emergencyContactName) { this.emergencyContactName = emergencyContactName; }
    
    public String getEmergencyContactRelation() { return emergencyContactRelation; }
    public void setEmergencyContactRelation(String emergencyContactRelation) { this.emergencyContactRelation = emergencyContactRelation; }
    
    public String getEmergencyContactPhone() { return emergencyContactPhone; }
    public void setEmergencyContactPhone(String emergencyContactPhone) { this.emergencyContactPhone = emergencyContactPhone; }

    public List<String> getAppointments() { return appointments; }
    public void setAppointments(List<String> appointments) { this.appointments = appointments; }

    public List<String> getPrescriptions() { return prescriptions; }
    public void setPrescriptions(List<String> prescriptions) { this.prescriptions = prescriptions; }

    public List<String> getBills() { return bills; }
    public void setBills(List<String> bills) { this.bills = bills; }


    @Override
public String toString() {
    return "Patient[" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", birthDate=" + birthDate +
            ", medicalHistory='" + medicalHistory + '\'' +
            ", contact='" + contact + '\'' +
            ", address='" + address + '\'' +
            ", gender='" + gender + '\'' +
            ", currentMedications=" + currentMedications +
            ", allergies=" + allergies +
            ", height=" + height +
            ", weight=" + weight +
            ", bmi=" + bmi +
            ", blood=" + blood +
            ", primaryDiagnosis='" + primaryDiagnosis + '\'' +
            ", insuranceProvider='" + insuranceProvider + '\'' +
            ", insurancePolicyNumber='" + insurancePolicyNumber + '\'' +
            ", emergencyContactName='" + emergencyContactName + '\'' +
            ", emergencyContactRelation='" + emergencyContactRelation + '\'' +
            ", emergencyContactPhone='" + emergencyContactPhone + '\'' +
            ", appointments=" + appointments +
            ", prescriptions=" + prescriptions +
            ", bills=" + bills +
            ']';
}


}
