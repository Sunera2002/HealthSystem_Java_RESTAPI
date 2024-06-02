/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.w1956408SuneraHealthSystem.model;

/**
 *
 * @author Sunera
 */
// Define the Billing class
public class Billing {
    // Instance variables to store billing ID, patient, doctor, invoice number, amount, and payment status
    private int id;
    private Patient patient;
    private Doctor doctor;
    private String invoiceNumber;
    private double amount;
    private String paymentStatus;
    
    // Constructor to initialize a Billing object with ID, patient, doctor, invoice number, amount, and payment status
    public Billing(int id, Patient patient, Doctor doctor, String invoiceNumber, double amount, String paymentStatus) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.invoiceNumber = invoiceNumber;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }
    public Billing() {
        
    }

    // Getter method to retrieve the billing ID
    public int getId() {
        return id;
    }

    // Getter method to retrieve the patient associated with the billing
    public Patient getPatient() {
        return patient;
    }
    
    // Getter method to retrieve the doctor associated with the billing
    public Doctor getDoctor() {
        return doctor;
    }

    // Getter method to retrieve the invoice number
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    // Getter method to retrieve the amount billed
    public double getAmount() {
        return amount;
    }

    // Getter method to retrieve the payment status
    public String getPaymentStatus() {
        return paymentStatus;
    }

    // Setter method to update the billing ID
    public void setId(int id) {
        this.id = id;
    }

    // Setter method to update the patient associated with the billing
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    // Setter method to update the doctor associated with the billing
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    // Setter method to update the invoice number
    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    // Setter method to update the amount billed
    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Setter method to update the payment status
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}

