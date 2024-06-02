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
import java.util.*;
public class DoctorDAO { // Define the DoctorDAO class
    private static List<Doctor> doctors = new ArrayList<>(); // Static list to store Doctor objects
    static { // Static initialization block to populate initial data
        doctors.add(new Doctor(789, "Dr. Jane Smith","0769841303","London","Hepatologist"));
        doctors.add(new Doctor(123, "Dr. Steven Anderson","7654332232","Bristol","Oncologist"));
    }

    public List<Doctor> getAllDoctors() {  // Method to retrieve all Doctor objects
        return doctors;
    }
   
    public Doctor getDoctorById(int id) {  // Method to retrieve a Doctor object by ID
        for (Doctor doctor : doctors) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        return null;
    }
    
    public void addDoctor(Doctor doctor) { // Method to add a new Doctor object       
        int newDoctorId = getNextDoctorId(); // Generate a new ID for the doctor
        doctor.setId(newDoctorId);        
        doctors.add(doctor); // Add the doctor to the list
    }
    
    public void updateDoctor(Doctor updatedDoctor) { // Method to update an existing Doctor object
        for (int i = 0; i < doctors.size(); i++) {
            Doctor doctor = doctors.get(i);
            if (doctor.getId() == updatedDoctor.getId()) {               
                doctors.set(i, updatedDoctor); // Replace the existing doctor with the updated doctor
                System.out.println("Doctor updated: " + updatedDoctor);
                return;
            }
        }
    }

    // Method to delete a Doctor object by ID
    public void deleteDoctor(int id) {
        // Remove the doctor matching the given ID
        doctors.removeIf(doctor -> doctor.getId() == id);
    }
    
    // Method to get the next available ID for a new Doctor object
    public int getNextDoctorId() {
        // Initialize maxDoctorId with a value lower than any possible doctor ID
        int maxDoctorId = Integer.MIN_VALUE;

        // Iterate through the list to find the maximum doctor ID
        for (Doctor doctor : doctors) {
            int doctorId = doctor.getId();
            if (doctorId > maxDoctorId) {
                maxDoctorId = doctorId;
            }
        }

        // Increment the maximum doctor ID to get the next available doctor ID
        return maxDoctorId + 1;
    }
}
