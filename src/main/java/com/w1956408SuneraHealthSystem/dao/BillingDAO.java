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
import com.w1956408SuneraHealthSystem.model.Patient;
import java.util.*;
public class BillingDAO {// Define the BillingDAO class
    // Static list to store Billing objects
    private static List<Billing> billings = new ArrayList<>();

    // Static initialization block to populate initial data
    static {
        // Create sample Patient objects
        Patient patient1 = new Patient(456, "John Doe", "0711212123", "London", "Cirrhosis", "good");
        Patient patient2 = new Patient(345, "James Watson", "0773434345", "Birmingham", "Cancer", "bad");

        // Add sample Doctor objects
        Doctor doctor1 = new Doctor(789, "Dr. Jane Smith", "0769841303", "London", "Hepatologist");
        Doctor doctor2 = new Doctor(123, "Dr. Steven Anderson", "7654332232", "Bristol", "Oncologist");

        // Add sample Billing objects
        billings.add(new Billing(1, patient1, doctor1, "1234", 5000, "done"));
        billings.add(new Billing(1, patient2, doctor2, "3456", 10000, "done"));
        // Add more Billing objects as needed(if needed)
    }

    // Method to retrieve all Billing objects
    public List<Billing> getAllBillings() {
        return billings;
    }

    // Method to retrieve a Billing object by ID
    public Billing getBillingById(int id) {
        for (Billing billing : billings) {
            if (billing.getId() == id) {
                return billing;
            }
        }
        return null;
    }

    // Method to add a new Billing object
    public void addBilling(Billing billing) {
        billings.add(billing);
    }

    // Method to update an existing Billing object
    public void updateBilling(Billing updatedBilling) {
        for (int i = 0; i < billings.size(); i++) {
            Billing billing = billings.get(i);
            if (billing.getId() == updatedBilling.getId()) {
                billings.set(i, updatedBilling);
                return;
            }
        }
    }

    // Method to delete a Billing object by ID
    public void deleteBilling(int id) {
        billings.removeIf(billing -> billing.getId() == id);
    }
}
