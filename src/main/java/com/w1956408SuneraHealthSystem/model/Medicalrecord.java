/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.w1956408SuneraHealthSystem.model;

/**
 *
 * @author Sunera
 */
// Define the MedicalRecord class
public class Medicalrecord {
    // Instance variables to store medical record ID, patient, diagnoses, and treatments
    private int id;
    private Patient patient;
    private String diagnoses;
    private String treatments;
    
    // Constructor to initialize a MedicalRecord object with ID, patient, diagnoses, and treatments
    public Medicalrecord(int id, Patient patient, String diagnoses, String treatments) {
        this.id = id;
        this.patient = patient;
        this.diagnoses = diagnoses;
        this.treatments = treatments;
    }
    public Medicalrecord() {
        
    }
     
    // Getter method to retrieve the medical record ID
    public int getId() {
        return id;
    }
    
    // Getter method to retrieve the patient associated with the medical record
    public Patient getPatient() {
        return patient;
    }

    // Getter method to retrieve the diagnoses recorded in the medical record
    public String getDiagnoses() {
        return diagnoses;
    }

    // Getter method to retrieve the treatments recorded in the medical record
    public String getTreatments() {
        return treatments;
    }

    // Setter method to update the medical record ID
    public void setId(int id) {
        this.id = id;
    }

    // Setter method to update the patient associated with the medical record
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    // Setter method to update the diagnoses recorded in the medical record
    public void setDiagnoses(String diagnoses) {
        this.diagnoses = diagnoses;
    }

    // Setter method to update the treatments recorded in the medical record
    public void setTreatments(String treatments) {
        this.treatments = treatments;
    }
}
