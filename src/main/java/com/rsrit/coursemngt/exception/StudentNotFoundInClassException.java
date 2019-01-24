package com.rsrit.coursemngt.exception;

public class StudentNotFoundInClassException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentNotFoundInClassException(String string) {
		super(string);
	}

	public StudentNotFoundInClassException() {
	}

	public StudentNotFoundInClassException(String string, Exception cause, int noDataAvailable) {
		super(string, cause);
	}
}
