/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.w1956408SuneraHealthSystem.model;

/**
 *
 * @author Sunera
 */
// Define the Prescription class
public class Prescription {
    // Instance variables to store prescription ID, patient, medication, dosage, instructions, and duration
    private int id;
    private Patient patient;
    private String medication;
    private String dosage;
    private String instructions;
    private String duration;
    
    // Constructor to initialize a Prescription object with ID, patient, medication, dosage, instructions, and duration
    public Prescription(int id, Patient patient, String medication, String dosage, String instructions, String duration) {
        this.id = id;
        this.patient = patient;
        this.medication = medication;
        this.dosage = dosage;
        this.instructions = instructions;
        this.duration = duration;
    }
    public Prescription() {
       
    }

    // Getter method to retrieve the prescription ID
    public int getId() {
        return id;
    }

    // Getter method to retrieve the patient associated with the prescription
    public Patient getPatient() {
        return patient;
    }

    // Getter method to retrieve the medication prescribed
    public String getMedication() {
        return medication;
    }

    // Getter method to retrieve the dosage of the medication prescribed
    public String getDosage() {
        return dosage;
    }

    // Getter method to retrieve the instructions for taking the medication
    public String getInstructions() {
        return instructions;
    }

    // Getter method to retrieve the duration for which the medication is prescribed
    public String getDuration() {
        return duration;
    }

    // Setter method to update the prescription ID
    public void setId(int id) {
        this.id = id;
    }

    // Setter method to update the patient associated with the prescription
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    // Setter method to update the medication prescribed
    public void setMedication(String medication) {
        this.medication = medication;
    }

    // Setter method to update the dosage of the medication prescribed
    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    // Setter method to update the instructions for taking the medication
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    // Setter method to update the duration for which the medication is prescribed
    public void setDuration(String duration) {
        this.duration = duration;
    }
}
