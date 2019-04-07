package ar.edu.university.commissionsadmin.rest.controllers;

import org.springframework.http.HttpStatus;

public class ApiError {

	final private HttpStatus status;
	final private String message;

	public ApiError(HttpStatus status, String message) {		
		this.status = status;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getStatus() {
		return status;
	}

}
