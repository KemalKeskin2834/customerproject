package com.kemalkeskin.bankCustomers.service.abstracts;

import java.util.List;

import com.kemalkeskin.bankCustomers.service.dtoS.IndividualCustomerRequest;
import com.kemalkeskin.bankCustomers.service.dtoS.IndividualCustomerResponse;

public interface IndividualCustomerService {

	List<IndividualCustomerResponse>listIndividualCustomer();
	
	IndividualCustomerResponse getById(int id);
	
	void addIndividualCustomer(IndividualCustomerRequest individualCustomerRequest);
	
	void updateIndividualCustomer(int id,IndividualCustomerRequest individualCustomerRequest);
	
	void deleteIndividualCustomer(int id);
}
