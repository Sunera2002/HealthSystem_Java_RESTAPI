/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.w1956408SuneraHealthSystem.resource;

/**
 *
 * @author Sunera
 */
import com.w1956408SuneraHealthSystem.dao.BillingDAO;
import com.w1956408SuneraHealthSystem.model.Billing;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/billings")
public class BillingResourse {
    // Logger for logging information and errors
    private static final Logger logger = LoggerFactory.getLogger(BillingResourse.class);
    // Data Access Object for billing operations
    private BillingDAO billingDAO = new BillingDAO();

    // GET method to fetch all billings
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Billing> getAllBilling() {
        try {
            // Log the action
            logger.info("Fetching all billings.");
            // Retrieve and return all billings
            return billingDAO.getAllBillings();
        } catch (Exception e) {
            // Log and throw a WebApplicationException with INTERNAL_SERVER_ERROR status if an error occurs
            logger.error("Failed to fetch all billings: {}", e.getMessage());
            throw new WebApplicationException("Failed to fetch all billings", e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    // GET method to fetch a billing by its ID
    @GET
    @Path("/{billingId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Billing getBillingById(@PathParam("billingId") int billingId) {
        try {
            // Log the action
            logger.info("Fetching billing with ID: {}", billingId);
            // Retrieve and return the billing with the specified ID
            return billingDAO.getBillingById(billingId);
        } catch (Exception e) {
            // Log and throw a WebApplicationException with INTERNAL_SERVER_ERROR status if an error occurs
            logger.error("Failed to fetch billing with ID {}: {}", billingId, e.getMessage());
            throw new WebApplicationException("Failed to fetch billing with ID " + billingId, e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    // POST method to add a new billing
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBilling(Billing billing) {
        try {
            // Log the action
            logger.info("Adding a new billing.");
            // Add the new billing
            billingDAO.addBilling(billing);
            // Return a response with CREATED status
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            // Log and throw a WebApplicationException with INTERNAL_SERVER_ERROR status if an error occurs
            logger.error("Failed to add billing: {}", e.getMessage());
            throw new WebApplicationException("Failed to add billing", e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    // PUT method to update an existing billing
    @PUT
    @Path("/{billingId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBilling(@PathParam("billingId") int billingId, Billing updatedBilling) {
        try {
            // Log the action
            logger.info("Updating billing with ID: {}", billingId);
            // Retrieve the existing billing
            Billing existingBilling = billingDAO.getBillingById(billingId);
            if (existingBilling != null) {
                // If the billing exists, update it with the provided data
                updatedBilling.setId(billingId);
                billingDAO.updateBilling(updatedBilling);
                // Return a response with OK status
                return Response.status(Response.Status.OK).build();
            } else {
                // If the billing does not exist, log and throw a WebApplicationException with NOT_FOUND status
                logger.error("Billing with ID {} not found.", billingId);
                throw new WebApplicationException("Billing with ID " + billingId + " not found.", Response.Status.NOT_FOUND);
            }
        } catch (Exception e) {
            // Log and throw a WebApplicationException with INTERNAL_SERVER_ERROR status if an error occurs
            logger.error("Failed to update billing with ID {}: {}", billingId, e.getMessage());
            throw new WebApplicationException("Failed to update billing with ID " + billingId, e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    // DELETE method to delete a billing by its ID
    @DELETE
    @Path("/{billingId}")
    public Response deleteBilling(@PathParam("billingId") int billingId) {
        try {
            // Log the action
            logger.info("Deleting billing with ID: {}", billingId);
            // Delete the billing with the specified ID
            billingDAO.deleteBilling(billingId);
            // Return a response with NO_CONTENT status
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception e) {
            // Log and throw a WebApplicationException with INTERNAL_SERVER_ERROR status if an error occurs
            logger.error("Failed to delete billing with ID {}: {}", billingId, e.getMessage());
            throw new WebApplicationException("Failed to delete billing with ID " + billingId, e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
}
