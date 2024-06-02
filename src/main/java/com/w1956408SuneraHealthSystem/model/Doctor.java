/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.w1956408SuneraHealthSystem.model;

/**
 *
 * @author Sunera
 */

public class Doctor extends Person{// Define the Doctor class which extends the Person class
    private String specialization;// Additional instance variable specific to the Doctor class

    // Constructor to initialize a Doctor object with name, contact info, address and specialization
    public Doctor(int id, String name, String contactInfo, String address, String specialization) {
        // Call the constructor of the superclass (Person) to initialize name, contact info, and address
        super(id, name, contactInfo, address);
        // Initialize specialization specific to Doctor class
        this.specialization = specialization;
    }
    public Doctor() {
    }

    // Getter method to retrieve the specialization of the doctor
    public String getSpecialization() {
        return this.specialization;
    }

    // Setter method to update the specialization of the doctor
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
