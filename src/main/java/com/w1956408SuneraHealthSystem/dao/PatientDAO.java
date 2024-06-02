/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.w1956408SuneraHealthSystem.dao;

/**
 *
 * @author Sunera
 */
import com.w1956408SuneraHealthSystem.model.Patient;
import java.util.*;
public class PatientDAO { // Define the PatientDAO class
    private static List<Patient> patients = new ArrayList<>(); // Static list to store Patient objects
    
    static { // Static initialization block to populate initial data
        patients.add(new Patient(456, "John Doe","0711212123","London","Cirrhosis","good"));
        patients.add(new Patient(345, "James Watson","0773434345","Birmingham","Cancer","bad"));
    }
    
    public List<Patient> getAllPatients() { // Method to retrieve all Patient objects
        return patients;
    }
    
    public Patient getPatientById(int id) { // Method to retrieve a Patient object by ID
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    public void addPatient(Patient patient) { // Method to add a new Patient object
        int newPatientId = getNextPatientId(); // Generate a new ID for the patient
        patient.setId(newPatientId);
        patients.add(patient); // Add the patient to the list
    }

    public void updatePatient(Patient updatedPatient) { // Method to update an existing Patient object
        for (int i = 0; i < patients.size(); i++) {
            Patient patient = patients.get(i);
            if (patient.getId() == updatedPatient.getId()) {            
                patients.set(i, updatedPatient); // Replace the existing patient with the updated patient
                System.out.println("Patient updated: " + updatedPatient);
                return;
            }
        }
    }

    // Method to delete a Patient object by ID
    public void deletePatient(int id) {
        // Remove the patient matching the given ID
        patients.removeIf(person -> person.getId() == id);
    }
    
    // Method to get the next available ID for a new Patient object
    public int getNextPatientId() {
        // Initialize maxPatientId with a value lower than any possible patient ID
        int maxPatientId = Integer.MIN_VALUE;

        // Iterate through the list to find the maximum patient ID
        for (Patient patient : patients) {
            int patientId = patient.getId();
            if (patientId > maxPatientId) {
                maxPatientId = patientId;
            }
        }

        // Increment the maximum patient ID to get the next available patient ID
        return maxPatientId + 1;
    }
}
