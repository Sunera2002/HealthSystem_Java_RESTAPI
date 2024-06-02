/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.w1956408SuneraHealthSystem.dao;

/**
 *
 * @author Sunera
 */
import com.w1956408SuneraHealthSystem.model.Doctor;
import com.w1956408SuneraHealthSystem.model.Patient;
import com.w1956408SuneraHealthSystem.model.Prescription;
import java.util.*;
public class PrescriptionDAO { // Define the PrescriptionDAO class
    // Static list to store Prescription objects
    private static List<Prescription> prescriptions = new ArrayList<>();

    // Static initialization block to populate initial data
    static {
        // Create sample Patient objects
        Patient patient1 = new Patient(456, "John Doe", "0711212123", "London", "Cirrhosis", "good");
        Patient patient2 = new Patient(345, "James Watson", "0773434345", "Birmingham", "Cancer", "bad");

        // Add sample Doctor objects
        Doctor doctor1 = new Doctor(789, "Dr. Jane Smith", "0769841303", "London", "Hepatologist");
        Doctor doctor2 = new Doctor(123, "Dr. Steven Anderson", "7654332232", "Bristol", "Oncologist");

        // Add sample Prescription objects
        prescriptions.add(new Prescription(1, patient1, "panadol", "120", "xxxxx", "2 days"));
        prescriptions.add(new Prescription(2, patient2, "Allegra", "240", "xxxxx", "3 months"));
        // Add more Prescription objects as needed
    }

    // Method to retrieve all Prescription objects
    public List<Prescription> getAllPrescriptions() {
        return prescriptions;
    }

    // Method to retrieve a Prescription object by ID
    public Prescription getPrescriptionById(int id) {
        for (Prescription prescription : prescriptions) {
            if (prescription.getId() == id) {
                return prescription;
            }
        }
        return null;
    }

    // Method to add a new Prescription object
    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    // Method to update an existing Prescription object
    public void updatePrescription(Prescription updatedPrescription) {
        for (int i = 0; i < prescriptions.size(); i++) {
            Prescription prescription = prescriptions.get(i);
            if (prescription.getId() == updatedPrescription.getId()) {
                prescriptions.set(i, updatedPrescription);
                return;
            }
        }
    }

    // Method to delete a Prescription object by ID
    public void deletePrescription(int id) {
        prescriptions.removeIf(prescription -> prescription.getId() == id);
    }
}
