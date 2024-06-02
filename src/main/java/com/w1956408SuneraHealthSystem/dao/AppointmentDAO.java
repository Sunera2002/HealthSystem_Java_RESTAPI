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
import com.w1956408SuneraHealthSystem.model.Appointment;
import com.w1956408SuneraHealthSystem.model.Doctor;
import java.util.*;
public class AppointmentDAO { // Define the AppointmentDAO class
    // Static list to store Appointment objects
    private static final List<Appointment> appointments = new ArrayList<>();

    // Static initialization block to populate initial data
    static {
        // Create sample Patient objects
        Patient patient1 = new Patient(1, "John Doe", "0769841303", "battaramulla", "PTSD", "good");
        Patient patient2 = new Patient(2, "Jane Dane", "7654332232", "kollupitiya", "ADHD", "bad");

        // Create sample Doctor objects
        Doctor doctor1 = new Doctor(1, "John Doe", "0769841303", "battaramulla", "skin specialist");
        Doctor doctor2 = new Doctor(2, "Jane Dane", "7654332232", "kollupitiya", "mind specialist");

        // Add sample appointments
        appointments.add(new Appointment(1, patient1, doctor1, "tuesday", "12.34"));
        appointments.add(new Appointment(2, patient2, doctor2, "monday", "11.30"));
        // Add more appointments as needed
    }

    // Method to retrieve all Appointment objects
    public List<Appointment> getAllAppointments() {
        return appointments;
    }

    // Method to retrieve an Appointment object by ID
    public Appointment getAppointmentById(int id) {
        for (Appointment appointment : appointments) {
            if (appointment.getId() == id) {
                return appointment;
            }
        }
        return null;
    }

    // Method to add a new Appointment object
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    // Method to update an existing Appointment object
    public void updateAppointment(Appointment updatedAppointment) {
        for (int i = 0; i < appointments.size(); i++) {
            Appointment appointment = appointments.get(i);
            if (appointment.getId() == updatedAppointment.getId()) {
                appointments.set(i, updatedAppointment);
                return;
            }
        }
    }

    // Method to delete an Appointment object by ID
    public void deleteAppointment(int id) {
        appointments.removeIf(appointment -> appointment.getId() == id);
    }
}
