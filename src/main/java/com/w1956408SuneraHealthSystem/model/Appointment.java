/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.w1956408SuneraHealthSystem.model;

/**
 *
 * @author Sunera
 */
// Define the Appointment class
public class Appointment {
    // Instance variables to store appointment ID, patient, doctor, date, and time
    private int id;
    private Patient patient;
    private Doctor doctor;
    private String date;
    private String time;
    
    // Constructor to initialize an Appointment object with ID, patient, doctor, date, and time
    public Appointment(int id, Patient patient, Doctor doctor, String date, String time) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }
    public Appointment() {
        
    }
    
    // Getter method to retrieve the appointment ID
    public int getId() {
        return id;
    }
    
    // Getter method to retrieve the patient associated with the appointment
    public Patient getPatient() {
        return patient;
    }
    
    // Getter method to retrieve the doctor associated with the appointment
    public Doctor getDoctor() {
        return doctor;
    }
    
    // Getter method to retrieve the date of the appointment
    public String getDate() {
        return date;
    }
    
    // Getter method to retrieve the time of the appointment
    public String getTime() {
        return time;
    }
    
    // Setter method to update the appointment ID
    public void setId(int id) {
        this.id = id;
    }
    
    // Setter method to update the patient associated with the appointment
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    // Setter method to update the doctor associated with the appointment
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    // Setter method to update the date of the appointment
    public void setDate(String date) {
        this.date = date;
    }
    
    // Setter method to update the time of the appointment
    public void setTime(String time) {
        this.time = time;
    }
}