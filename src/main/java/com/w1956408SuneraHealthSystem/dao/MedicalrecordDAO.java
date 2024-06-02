/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.w1956408SuneraHealthSystem.dao;

/**
 *
 * @author Sunera
 */
import com.w1956408SuneraHealthSystem.model.Billing;
import com.w1956408SuneraHealthSystem.model.Doctor;
import com.w1956408SuneraHealthSystem.model.Medicalrecord;
import com.w1956408SuneraHealthSystem.model.Patient;
import java.util.*;
public class MedicalrecordDAO { // Define the MedicalrecordDAO class
    // Static list to store Medicalrecord objects
    private static List<Medicalrecord> medicalrecords = new ArrayList<>();

    // Static initialization block to populate initial data
    static {
        // Create sample Patient objects
        Patient patient1 = new Patient(456, "John Doe", "0711212123", "London", "Cirrhosis", "good");
        Patient patient2 = new Patient(345, "James Watson", "0773434345", "Birmingham", "Cancer", "bad");

        // Create sample Doctor objects
        Doctor doctor1 = new Doctor(789, "Dr. Jane Smith", "0769841303", "London", "Hepatologist");
        Doctor doctor2 = new Doctor(123, "Dr. Steven Anderson", "7654332232", "Bristol", "Oncologist");

        // Add sample Medicalrecord objects
        medicalrecords.add(new Medicalrecord(1, patient1, "doctor1", "1234"));
        medicalrecords.add(new Medicalrecord(2, patient2, "3456", "done"));
        // Add more Medicalrecord objects as needed
    }

    // Method to retrieve all Medicalrecord objects
    public List<Medicalrecord> getAllMedicalRecords() {
        return medicalrecords;
    }

    // Method to retrieve a Medicalrecord object by ID
    public Medicalrecord getMedicalRecordById(int id) {
        for (Medicalrecord medicalRecord : medicalrecords) {
            if (medicalRecord.getId() == id) {
                return medicalRecord;
            }
        }
        return null;
    }

    // Method to add a new Medicalrecord object
    public void addMedicalRecord(Medicalrecord medicalRecord) {
        medicalrecords.add(medicalRecord);
    }

    // Method to update an existing Medicalrecord object
    public void updateMedicalRecord(Medicalrecord updatedMedicalRecord) {
        for (int i = 0; i < medicalrecords.size(); i++) {
            Medicalrecord medicalRecord = medicalrecords.get(i);
            if (medicalRecord.getId() == updatedMedicalRecord.getId()) {
                medicalrecords.set(i, updatedMedicalRecord);
                return;
            }
        }
    }

    // Method to delete a Medicalrecord object by ID
    public void deleteMedicalRecord(int id) {
        medicalrecords.removeIf(medicalRecord -> medicalRecord.getId() == id);
    }
}
