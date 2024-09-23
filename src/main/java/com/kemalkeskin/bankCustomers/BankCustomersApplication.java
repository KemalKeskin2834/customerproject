package com.kemalkeskin.bankCustomers;

import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.kemalkeskin.bankCustomers.core.exception.BusinessException;
import com.kemalkeskin.bankCustomers.core.exception.ProblemDetails;
import com.kemalkeskin.bankCustomers.core.exception.ValidationException;

@SpringBootApplication
@RestControllerAdvice

public class BankCustomersApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankCustomersApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails problemDetails(BusinessException businessException) {
		ProblemDetails problemDetails=new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		return problemDetails;
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
		
		ValidationException validationException=new ValidationException();
		validationException.setMessage("VALIDATION.EXCEPTİON");
		
		validationException.setValidationErrors(new HashMap<String, String>());
		
		for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validationException.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return validationException;
	}
}
	

