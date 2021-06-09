package com.capgemini.personality.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateIdFoundException extends RuntimeException {
	public DuplicateIdFoundException() {
		super();
	}

	public DuplicateIdFoundException(String msg) {
		super(msg);
	}

}
