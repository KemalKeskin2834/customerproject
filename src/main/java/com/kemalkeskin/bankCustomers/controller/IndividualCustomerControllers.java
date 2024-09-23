package com.kemalkeskin.bankCustomers.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kemalkeskin.bankCustomers.service.abstracts.IndividualCustomerService;
import com.kemalkeskin.bankCustomers.service.dtoS.IndividualCustomerRequest;
import com.kemalkeskin.bankCustomers.service.dtoS.IndividualCustomerResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/individualcustomer")
public class IndividualCustomerControllers {
	
	private IndividualCustomerService individualCustomerService;

	public IndividualCustomerControllers(IndividualCustomerService individualCustomerService) {
		this.individualCustomerService = individualCustomerService;
	}
	
	@GetMapping("/individualcustomers")
	public List<IndividualCustomerResponse> listIndividualCustomer(){
		return individualCustomerService.listIndividualCustomer();
	}

	@GetMapping("/individualcustomers/{id}")
	public IndividualCustomerResponse getById(@PathVariable int id) {
		return individualCustomerService.getById(id);
	}
	
	@PostMapping("/individualcustomers/aad")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addIndividualCustomer(@Valid  @RequestBody IndividualCustomerRequest individualCustomerRequest) {
		this.individualCustomerService.addIndividualCustomer(individualCustomerRequest);
	}
	
	@PutMapping("/individualcustomers/update/{id}")
	public void updateIndividualCustomer(@Valid @PathVariable int id,@RequestBody IndividualCustomerRequest individualCustomerRequest) {
		this.individualCustomerService.updateIndividualCustomer(id, individualCustomerRequest);
	}
	
	@DeleteMapping("/individualcustomers/delete/{id}")
	public void deleteIndividualCustomer(@PathVariable int id) {
		this.individualCustomerService.deleteIndividualCustomer(id);
	}
}
