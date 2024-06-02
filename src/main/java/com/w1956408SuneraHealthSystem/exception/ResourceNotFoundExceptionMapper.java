/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.w1956408SuneraHealthSystem.exception;

/**
 *
 * @author Sunera
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * This class handles the mapping of ResourceNotFoundException to a corresponding HTTP response.
 * It implements the ExceptionMapper interface, allowing it to be registered as an exception handler in JAX-RS.
 */
@Provider
public class ResourceNotFoundExceptionMapper implements ExceptionMapper<ResourceNotFoundException> {
    // Logger for logging information and errors
    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceNotFoundExceptionMapper.class);

    /**
     * This method is called when a ResourceNotFoundException is thrown.
     * It logs the exception and generates an HTTP response with a NOT_FOUND status.
     *
     * @param exception The ResourceNotFoundException that was thrown
     * @return HTTP response with NOT_FOUND status and an error message in the entity body
     */
    @Override
    public Response toResponse(ResourceNotFoundException exception) { // Log the exception
        LOGGER.error("ResourceNotFoundException caught: {}", exception.getMessage(), exception);

        // Build and return the HTTP response
        return Response.status(Response.Status.NOT_FOUND)
                .entity(exception.getMessage()) // Set the error message in the response body
                .type(MediaType.TEXT_PLAIN) // Set the media type of the response body
                .build();
    }
}
