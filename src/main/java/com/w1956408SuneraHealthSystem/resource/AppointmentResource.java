/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.w1956408SuneraHealthSystem.resource;

/**
 *
 * @author Sunera
 */
import com.w1956408SuneraHealthSystem.dao.AppointmentDAO;
import com.w1956408SuneraHealthSystem.model.Appointment;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/appointments")
public class AppointmentResource {
    // Logger for logging information and errors
    private static final Logger logger = LoggerFactory.getLogger(AppointmentResource.class);
    
    // Data Access Object for appointment operations
    private AppointmentDAO appointmentDAO = new AppointmentDAO();

    // GET method to fetch all appointments
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Appointment> getAllAppointments() {
        try {
            // Log the action
            logger.info("Fetching all appointments.");
            // Retrieve and return all appointments
            return appointmentDAO.getAllAppointments();
        } catch (Exception e) {
            // Log and throw a WebApplicationException with INTERNAL_SERVER_ERROR status if an error occurs
            logger.error("Failed to fetch all appointments: {}", e.getMessage());
            throw new WebApplicationException("Failed to fetch all appointments", e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    // GET method to fetch a specific appointment by ID
    @GET
    @Path("/{appointmentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Appointment getAppointmentById(@PathParam("appointmentId") int appointmentId) {
        try {
            // Log the action
            logger.info("Fetching appointment with ID: {}", appointmentId);
            // Retrieve and return the appointment with the specified ID
            return appointmentDAO.getAppointmentById(appointmentId);
        } catch (Exception e) {
            // Log and throw a WebApplicationException with INTERNAL_SERVER_ERROR status if an error occurs
            logger.error("Failed to fetch appointment with ID {}: {}", appointmentId, e.getMessage());
            throw new WebApplicationException("Failed to fetch appointment with ID " + appointmentId, e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    // POST method to add a new appointment
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAppointment(Appointment appointment) {
        try {
            // Log the action
            logger.info("Adding a new appointment.");
            // Add the new appointment
            appointmentDAO.addAppointment(appointment);
            // Return a response with CREATED status
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            // Log and throw a WebApplicationException with INTERNAL_SERVER_ERROR status if an error occurs
            logger.error("Failed to add appointment: {}", e.getMessage());
            throw new WebApplicationException("Failed to add appointment", e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    // PUT method to update an existing appointment
    @PUT
    @Path("/{appointmentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAppointment(@PathParam("appointmentId") int appointmentId, Appointment updatedAppointment) {
        try {
            // Log the action
            logger.info("Updating appointment with ID: {}", appointmentId);
            // Retrieve the existing appointment
            Appointment existingAppointment = appointmentDAO.getAppointmentById(appointmentId);
            if (existingAppointment != null) {
                // Set the ID of the updated appointment
                updatedAppointment.setId(appointmentId);
                // Update the appointment
                appointmentDAO.updateAppointment(updatedAppointment);
                // Return a response with OK status
                return Response.status(Response.Status.OK).build();
            } else {
                // Log and throw a WebApplicationException with NOT_FOUND status if the appointment is not found
                logger.error("Appointment with ID {} not found.", appointmentId);
                throw new WebApplicationException("Appointment with ID " + appointmentId + " not found.", Response.Status.NOT_FOUND);
            }
        } catch (Exception e) {
            // Log and throw a WebApplicationException with INTERNAL_SERVER_ERROR status if an error occurs
            logger.error("Failed to update appointment with ID {}: {}", appointmentId, e.getMessage());
            throw new WebApplicationException("Failed to update appointment with ID " + appointmentId, e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    // DELETE method to delete an existing appointment
    @DELETE
    @Path("/{appointmentId}")
    public Response deleteAppointment(@PathParam("appointmentId") int appointmentId) {
        try {
            // Log the action
            logger.info("Deleting appointment with ID: {}", appointmentId);
            // Delete the appointment
            appointmentDAO.deleteAppointment(appointmentId);
            // Return a response with NO_CONTENT status
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception e) {
            // Log and throw a WebApplicationException with INTERNAL_SERVER_ERROR status if an error occurs
            logger.error("Failed to delete appointment with ID {}: {}", appointmentId, e.getMessage());
            throw new WebApplicationException("Failed to delete appointment with ID " + appointmentId, e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
}
