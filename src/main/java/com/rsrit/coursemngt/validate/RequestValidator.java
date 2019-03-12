package com.rsrit.coursemngt.validate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.rsrit.coursemngt.model.Class;


@Component
public class RequestValidator implements Validator {

	public boolean supports(Class clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		String name = ((Class) target).getClassName();
        if(name == "" || name.isEmpty()) {
            try {
				throw new Exception("A valid name is missing. Please provide a valid Name.");
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
	}

	@Override
	public boolean supports(java.lang.Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

}
