package com.kemalkeskin.bankCustomers.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kemalkeskin.bankCustomers.model.BaseCustomer;
import com.kemalkeskin.bankCustomers.service.abstracts.BaseCustomerService;


@RestController
@RequestMapping("/basecustomer")
public class BaseCustomerControllers {
	
	private BaseCustomerService baseCustomerService;

	public BaseCustomerControllers(BaseCustomerService baseCustomerService) {
		this.baseCustomerService = baseCustomerService;
	}
	
	@GetMapping("/basecustomers")
	public List<BaseCustomer> listCustomers(){
		
		return baseCustomerService.listCustomers();
		
	}
	
	@GetMapping("/basecustomers/{id}")
	public BaseCustomer getById(@PathVariable int id) {
		return baseCustomerService.getById(id);
	}

}
