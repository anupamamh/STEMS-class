package com.rsrit.coursemngt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rsrit.coursemngt.exception.ClassesCustomGenericException;

@RestController
@ControllerAdvice
public class ClassesGlobalExceptonController {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ClassesCustomGenericException> handleGlobalExceptionsResponses(Exception ex,
			WebRequest request) {
		ClassesCustomGenericException errorResponse = new ClassesCustomGenericException(ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<ClassesCustomGenericException>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}
