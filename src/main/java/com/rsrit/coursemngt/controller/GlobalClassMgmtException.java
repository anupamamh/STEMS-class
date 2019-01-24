package com.rsrit.coursemngt.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rsrit.coursemngt.exception.ErrorDetails;

@RestController
@ControllerAdvice
// @Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalClassMgmtException extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<ErrorDetails> handleGlobalExceptionsResponses(Exception ex, WebRequest request) {
		ErrorDetails errorResponse = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		System.out.println(ex.getClass().getName());
		return new ResponseEntity<ErrorDetails>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	/*@Override
	@ExceptionHandler(RuntimeException.class)
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ErrorDetails errorResponse = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(errorResponse, status);
	}*/
	
	

}
