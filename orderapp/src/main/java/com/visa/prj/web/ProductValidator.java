package com.visa.prj.web;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.visa.prj.entity.Product;


@Component
public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name","name.req","Name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category","category.req","Category is required");
		
		Product p=(Product)obj;
		if(p.getPrice()<=0)
			errors.rejectValue("price", "price.posit","Price should be +");
		
	

	}

}
