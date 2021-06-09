package com.capgemini.personality.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ConstraintValidationException extends RuntimeException {

	public ConstraintValidationException() {
		super();
	}
	public ConstraintValidationException(String msg) {
		super(msg);
	}
}