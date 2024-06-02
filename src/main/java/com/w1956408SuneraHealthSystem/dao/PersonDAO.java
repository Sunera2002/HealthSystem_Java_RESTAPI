/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.w1956408SuneraHealthSystem.dao;

/**
 *
 * @author Sunera
 */
import com.w1956408SuneraHealthSystem.model.Person;
import java.util.*;
public class PersonDAO { // Define the PersonDAO class
    private static List<Person> persons = new ArrayList<>(); // Static list to store Person objects
    public List<Person> getAllPersons() { // Method to retrieve all Person objects
        return persons;
    }
    public Person getPersonById(int id) { // Method to retrieve a Person object by ID
        for (Person person : persons) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    public void addPerson(Person person) {  // Method to add a new Person object
        int newPersonId = getNextPersonId(); // Generate a new ID for the person
        person.setId(newPersonId);
        persons.add(person);    // Add the person to the list
    }

    public void updatePerson(Person updatedPerson) {  // Method to update an existing Person object
        for (int i = 0; i < persons.size(); i++) {
            Person person = persons.get(i);
            if (person.getId() == updatedPerson.getId()) {                
                persons.set(i, updatedPerson);  // Replace the existing person with the updated person
                System.out.println("Person updated: " + updatedPerson);
                return;
            }
        }
    }
  
    public void deletePerson(int id) {  // Method to delete a Person object by ID
        persons.removeIf(person -> person.getId() == id); // Remove the person matching the given ID
    }
    
    // Method to get the next available ID for a new Person object
    public int getNextPersonId() {
        // Initialize maxPersonId with a value lower than any possible person ID
        int maxPersonId = Integer.MIN_VALUE;

        // Iterate through the list to find the maximum person ID
        for (Person person : persons) {
            int personId = person.getId();
            if (personId > maxPersonId) {
                maxPersonId = personId;
            }
        }

        // Increment the maximum person ID to get the next available person ID
        return maxPersonId + 1;
    }
}
