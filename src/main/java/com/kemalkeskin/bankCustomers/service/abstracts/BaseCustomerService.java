package com.kemalkeskin.bankCustomers.service.abstracts;

import java.util.List;

import com.kemalkeskin.bankCustomers.model.BaseCustomer;

public interface BaseCustomerService {
	
	List<BaseCustomer>listCustomers();
	
	BaseCustomer getById(int id);

}
