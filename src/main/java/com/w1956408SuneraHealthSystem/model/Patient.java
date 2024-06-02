/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.w1956408SuneraHealthSystem.model;

/**
 *
 * @author Sunera
 */
public class Patient extends Person{// Define the Patient class which extends the Person class
    // Additional instance variables specific to Patient class
    private String medicalHistory;
    private String currentHealthStatus;

    // Constructor to initialize a Patient object with name, contact info, address, medical history, and current health status
    public Patient(int id ,String name, String contactInfo, String address, String medicalHistory, String currentHealthStatus) {
        // Call the constructor of the superclass (Person) to initialize name, contact info, and address
        super(id, name, contactInfo, address);
        // Initialize medical history and current health status specific to Patient class
        this.medicalHistory = medicalHistory;
        this.currentHealthStatus = currentHealthStatus;
    }
    public Patient() {
       
    }

    // Getter method to retrieve the medical history of the patient
    public String getMedicalHistory() {
        return this.medicalHistory;
    }

    // Getter method to retrieve the current health status of the patient
    public String getCurrentHealthStatus() {
        return this.currentHealthStatus;
    }

    // Setter method to update the medical history of the patient
    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    // Setter method to update the current health status of the patient
    public void setCurrentHealthStatus(String currentHealthStatus) {
        this.currentHealthStatus = currentHealthStatus;
    }
}
