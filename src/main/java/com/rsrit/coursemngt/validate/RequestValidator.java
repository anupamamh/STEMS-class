package com.rsrit.coursemngt.validate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.rsrit.coursemngt.model.Classes;


@Component
public class RequestValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		String name = ((Classes) target).getClassName();
        if(name == "" || name.isEmpty()) {
            try {
				throw new Exception("A valid name is missing. Please provide a valid Name.");
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
	}

}
