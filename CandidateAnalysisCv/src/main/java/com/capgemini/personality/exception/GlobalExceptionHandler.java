package com.capgemini.personality.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice // interceptor that surrounds the logic in our Controllers
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class) // used for handling exceptions
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR) // reason that should be returned
	public ResponseEntity<Object> globalExceptionHandler(Exception ex, WebRequest request) {
		ExceptionResponse ExceptionResponse = new ExceptionResponse(new Date(0), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(ExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> resourceNotFoundException(NotFoundException ex, WebRequest request) {
		ExceptionResponse ExceptionResponse = new ExceptionResponse(new Date(0), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(ExceptionResponse, HttpStatus.NOT_FOUND);
	}



	@ExceptionHandler(ConstraintValidationException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> resourceNotFoundException(ConstraintValidationException ex, WebRequest request) {
		ExceptionResponse ExceptionResponse = new ExceptionResponse(new Date(0), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(ExceptionResponse, HttpStatus.BAD_REQUEST);
	}

}
