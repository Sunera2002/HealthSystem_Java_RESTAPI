/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.w1956408SuneraHealthSystem.resource;

/**
 *
 * @author Sunera
 */
import com.w1956408SuneraHealthSystem.dao.DoctorDAO;
import com.w1956408SuneraHealthSystem.model.Doctor;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/doctors") // Define the DoctorResource class as a JAX-RS resource with base path "/doctors"
public class DoctorResourse { 
    // Logger for logging messages
    private static final Logger logger = LoggerFactory.getLogger(DoctorResourse.class);
    
    // DoctorDAO instance for handling data access operations
    private DoctorDAO doctorDAO = new DoctorDAO();

    // Method to fetch all doctors
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Doctor> getAllDoctors() {
        try {
            // Log message indicating fetching all doctors
            logger.info("Fetching all doctors.");
            // Call DoctorDAO to retrieve all doctors and return the list
            return doctorDAO.getAllDoctors();
        } catch (Exception e) {
            // Log error message if fetching fails
            logger.error("Failed to fetch all doctors: {}", e.getMessage());
            // Throw a WebApplicationException with an INTERNAL_SERVER_ERROR response status and the error message
            throw new WebApplicationException("Failed to fetch all doctors", e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    // Method to fetch a doctor by ID
    @GET
    @Path("/{doctorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Doctor getDoctorById(@PathParam("doctorId") int doctorId) {
        try {
            // Log message indicating fetching a doctor by ID
            logger.info("Fetching doctor with ID: {}", doctorId);
            // Call DoctorDAO to retrieve the doctor by ID and return it
            return doctorDAO.getDoctorById(doctorId);
        } catch (Exception e) {
            // Log error message if fetching fails
            logger.error("Failed to fetch doctor with ID {}: {}", doctorId, e.getMessage());
            // Throw a WebApplicationException with an INTERNAL_SERVER_ERROR response status and the error message
            throw new WebApplicationException("Failed to fetch doctor with ID " + doctorId, e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    // Method to add a new doctor
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDoctor(Doctor doctor) {
        try {
            // Log message indicating adding a new doctor
            logger.info("Adding a new doctor.");
            // Call DoctorDAO to add the new doctor
            doctorDAO.addDoctor(doctor);
            // Return a response with a CREATED status
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            // Log error message if adding fails
            logger.error("Failed to add doctor: {}", e.getMessage());
            // Throw a WebApplicationException with an INTERNAL_SERVER_ERROR response status and the error message
            throw new WebApplicationException("Failed to add doctor", e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    // Method to update an existing doctor
    @PUT
    @Path("/{doctorId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDoctor(@PathParam("doctorId") int doctorId, Doctor updatedDoctor) {
        try {
            // Log message indicating updating a doctor
            logger.info("Updating doctor with ID: {}", doctorId);
            // Retrieve the existing doctor by ID
            Doctor existingDoctor = doctorDAO.getDoctorById(doctorId);
            if (existingDoctor != null) {
                // If the doctor exists, set the ID of the updated doctor and update it in the database
                updatedDoctor.setId(doctorId);
                doctorDAO.updateDoctor(updatedDoctor);
                // Return a response with an OK status
                return Response.status(Response.Status.OK).build();
            } else {
                // Log error message if the doctor does not exist
                logger.error("Doctor with ID {} not found.", doctorId);
                // Throw a WebApplicationException with a NOT_FOUND response status and an appropriate error message
                throw new WebApplicationException("Doctor with ID " + doctorId + " not found.", Response.Status.NOT_FOUND);
            }
        } catch (Exception e) {
            // Log error message if updating fails
            logger.error("Failed to update doctor with ID {}: {}", doctorId, e.getMessage());
            // Throw a WebApplicationException with an INTERNAL_SERVER_ERROR response status and the error message
            throw new WebApplicationException("Failed to update doctor with ID " + doctorId, e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    // Method to delete a doctor by ID
    @DELETE
    @Path("/{doctorId}")
    public Response deleteDoctor(@PathParam("doctorId") int doctorId) {
        try {
            // Log message indicating deleting a doctor by ID
            logger.info("Deleting doctor with ID: {}", doctorId);
            // Call DoctorDAO to delete the doctor by ID
            doctorDAO.deleteDoctor(doctorId);
            // Return a response with a NO_CONTENT status
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception e) {
            // Log error message if deletion fails
            logger.error("Failed to delete doctor with ID {}: {}", doctorId, e.getMessage());
            // Throw a WebApplicationException with an INTERNAL_SERVER_ERROR response status and the error message
            throw new WebApplicationException("Failed to delete doctor with ID " + doctorId, e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

}
