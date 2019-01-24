package com.rsrit.coursemngt.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorDetails {

	private static final long serialVersionUID = 1L;
	 private HttpStatus status;
	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date timestamp;
	private String errorSource;
	private String errorMessage;
	private String debugMessage;
	

	public ErrorDetails(HttpStatus status)
	{
		this();
		this.status=status;
	}
	public ErrorDetails(Date timestamp, String errorMessage , String errorStatus ) {
		super();
		this.timestamp = timestamp;
		this.errorSource = errorStatus;
		this.errorMessage = errorMessage;
	}
	public ErrorDetails(HttpStatus status, Throwable ex) {
			super();
			this.status = status;
		       this.errorMessage = "Unexpected error";
		       this.debugMessage = ex.getLocalizedMessage();
	}
	ErrorDetails(HttpStatus status, String message, Throwable ex) {
	       this();
	       this.status = status;
	       this.errorMessage = ex.getMessage();
	       this.debugMessage = ex.getLocalizedMessage();
	   }

	public ErrorDetails() {
		super();// TODO Auto-generated constructor stub
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getErrorSource() {
		return errorSource;
	}

	public void setErrorSource(String errorStatus) {
		this.errorSource = errorStatus;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
