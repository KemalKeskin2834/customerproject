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

import com.kemalkeskin.bankCustomers.service.abstracts.CorporateCustomerService;
import com.kemalkeskin.bankCustomers.service.dtoS.CorporateCustomerRequest;
import com.kemalkeskin.bankCustomers.service.dtoS.CorporateCustomerResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/corporatecustomer")
public class CorporateCustomerControllers {

	private CorporateCustomerService corporateCustomerService;

	public CorporateCustomerControllers(CorporateCustomerService corporateCustomerService) {
		this.corporateCustomerService = corporateCustomerService;
	}
	
	@GetMapping("/corporatecustomers")
	public List<CorporateCustomerResponse> listCorporateCustomer(){
		return corporateCustomerService.listCorporateCustomer();
	}
	
	@GetMapping("/corporatecustomers/{id}")
	public CorporateCustomerResponse getById(@PathVariable int id) {
		return corporateCustomerService.getById(id);
	}
	
	@PostMapping("/corporatecustomers/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addCorporateCustomer(@Valid @RequestBody CorporateCustomerRequest corporateCustomerRequest) {
		this.corporateCustomerService.addCorporateCustomer(corporateCustomerRequest);
	}
	
	@PutMapping("/corporatecustomers/update/{id}")
	public void updateCorporateCustomer(@Valid @PathVariable int id,@RequestBody CorporateCustomerRequest corporateCustomerRequest) {
		this.corporateCustomerService.updateCorporateCustomer(id, corporateCustomerRequest);
	}

	@DeleteMapping("corporatecustomers/delete/{id}")
	public void delete(@PathVariable int id) {
		this.corporateCustomerService.delete(id);
	}

	
}
