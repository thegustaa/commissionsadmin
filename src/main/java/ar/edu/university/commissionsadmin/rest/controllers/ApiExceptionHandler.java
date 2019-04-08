package ar.edu.university.commissionsadmin.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ar.edu.university.commissionsadmin.core.exceptions.ForbiddenOperationException;

/**
 * Manejador de excepciones.
 * @author Gustavo
 *
 */
@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler({ ForbiddenOperationException.class })
	public ResponseEntity<Object> handleIOException(RuntimeException e){
		ApiError error= new ApiError(HttpStatus.FORBIDDEN, e.getMessage());
	    return new ResponseEntity<Object>(error, HttpStatus.FORBIDDEN);
	}
}
