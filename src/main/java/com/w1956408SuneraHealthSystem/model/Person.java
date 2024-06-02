/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.w1956408SuneraHealthSystem.model;

/**
 *
 * @author Sunera
 */
public class Person { //// Define the Person class
    // Instance variables to store name, contact info, and address
    private int id;
    private String name;
    private String contactInfo;
    private String address;
    
    // Constructor to initialize Person object with name, contact info, and address
    public Person(int id, String name, String contactInfo, String address) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
        this.address = address;
    }
    
    public Person() {
       
    }
    // Getter method to retrieve the id
    public int getId() {
        return id;
    }
    // Getter method to retrieve the name
    public String getName() {
        return this.name;
    }

    // Getter method to retrieve the contact information
    public String getContactInfo() {
        return this.contactInfo;
    }

    // Getter method to retrieve the address
    public String getAddress() {
        return this.address;
    }
    // Setter method to update the name
    public void setId(int id) {
        this.id = id;
    }
    // Setter method to update the name
    public void setName(String name) {
        this.name = name;
    }

    // Setter method to update the contact information
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    // Setter method to update the address
    public void setAddress(String address) {
        this.address = address;
    }
}
