package com.rsrit.coursemngt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class ClassDoesNotExistsException extends RuntimeException{

	public ClassDoesNotExistsException(String string) {
	super(string);
	}

	public ClassDoesNotExistsException() {
	super("======================");
	}
	
	public ClassDoesNotExistsException(String string, Exception cause, int noDataAvailable) {
		super(string,cause);
		//System.out.println(cause.getLocalizedMessage());
	}

	
}
