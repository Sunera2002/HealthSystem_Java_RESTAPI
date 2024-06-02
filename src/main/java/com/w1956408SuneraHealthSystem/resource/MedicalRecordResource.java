/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.w1956408SuneraHealthSystem.resource;

/**
 *
 * @author Sunera
 */
import com.w1956408SuneraHealthSystem.dao.MedicalrecordDAO;
import com.w1956408SuneraHealthSystem.model.Medicalrecord;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/medicalRecords")
public class MedicalRecordResource {
    // Logger for logging information and errors
    private static final Logger logger = LoggerFactory.getLogger(MedicalRecordResource.class);
    
    // Data Access Object for medical record operations
    private MedicalrecordDAO medicalRecordDAO = new MedicalrecordDAO();

    // GET method to fetch all medical records
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Medicalrecord> getAllMedicalRecords() {
        try {
            // Log the action
            logger.info("Fetching all medical records.");
            // Retrieve and return all medical records
            return medicalRecordDAO.getAllMedicalRecords();
        } catch (Exception e) {
            // Log and throw a WebApplicationException with INTERNAL_SERVER_ERROR status if an error occurs
            logger.error("Failed to fetch all medical records: {}", e.getMessage());
            throw new WebApplicationException("Failed to fetch all medical records", e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    // GET method to fetch a specific medical record by ID
    @GET
    @Path("/{medicalRecordId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Medicalrecord getMedicalRecordById(@PathParam("medicalRecordId") int medicalRecordId) {
        try {
            // Log the action
            logger.info("Fetching medical record with ID: {}", medicalRecordId);
            // Retrieve and return the medical record with the specified ID
            return medicalRecordDAO.getMedicalRecordById(medicalRecordId);
        } catch (Exception e) {
            // Log and throw a WebApplicationException with INTERNAL_SERVER_ERROR status if an error occurs
            logger.error("Failed to fetch medical record with ID {}: {}", medicalRecordId, e.getMessage());
            throw new WebApplicationException("Failed to fetch medical record with ID " + medicalRecordId, e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    // POST method to add a new medical record
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMedicalRecord(Medicalrecord medicalRecord) {
        try {
            // Log the action
            logger.info("Adding a new medical record.");
            // Add the new medical record
            medicalRecordDAO.addMedicalRecord(medicalRecord);
            // Return a response with CREATED status
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            // Log and throw a WebApplicationException with INTERNAL_SERVER_ERROR status if an error occurs
            logger.error("Failed to add medical record: {}", e.getMessage());
            throw new WebApplicationException("Failed to add medical record", e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    // PUT method to update an existing medical record
    @PUT
    @Path("/{medicalRecordId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMedicalRecord(@PathParam("medicalRecordId") int medicalRecordId, Medicalrecord updatedMedicalRecord) {
        try {
            // Log the action
            logger.info("Updating medical record with ID: {}", medicalRecordId);
            // Retrieve the existing medical record
            Medicalrecord existingMedicalRecord = medicalRecordDAO.getMedicalRecordById(medicalRecordId);
            if (existingMedicalRecord != null) {
                // Set the ID of the updated medical record
                updatedMedicalRecord.setId(medicalRecordId);
                // Update the medical record
                medicalRecordDAO.updateMedicalRecord(updatedMedicalRecord);
                // Return a response with OK status
                return Response.status(Response.Status.OK).build();
            } else {
                // Log and throw a WebApplicationException with NOT_FOUND status if the medical record is not found
                logger.error("Medical record with ID {} not found.", medicalRecordId);
                throw new WebApplicationException("Medical record with ID " + medicalRecordId + " not found.", Response.Status.NOT_FOUND);
            }
        } catch (Exception e) {
            // Log and throw a WebApplicationException with INTERNAL_SERVER_ERROR status if an error occurs
            logger.error("Failed to update medical record with ID {}: {}", medicalRecordId, e.getMessage());
            throw new WebApplicationException("Failed to update medical record with ID " + medicalRecordId, e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    // DELETE method to delete an existing medical record
    @DELETE
    @Path("/{medicalRecordId}")
    public Response deleteMedicalRecord(@PathParam("medicalRecordId") int medicalRecordId) {
        try {
            // Log the action
            logger.info("Deleting medical record with ID: {}", medicalRecordId);
            // Delete the medical record
            medicalRecordDAO.deleteMedicalRecord(medicalRecordId);
            // Return a response with NO_CONTENT status
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception e) {
            // Log and throw a WebApplicationException with INTERNAL_SERVER_ERROR status if an error occurs
            logger.error("Failed to delete medical record with ID {}: {}", medicalRecordId, e.getMessage());
            throw new WebApplicationException("Failed to delete medical record with ID " + medicalRecordId, e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
}