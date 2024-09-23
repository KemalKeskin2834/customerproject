package com.kemalkeskin.bankCustomers.service.abstracts;

import java.util.List;

import com.kemalkeskin.bankCustomers.service.dtoS.CorporateCustomerRequest;
import com.kemalkeskin.bankCustomers.service.dtoS.CorporateCustomerResponse;

public interface CorporateCustomerService {

	List<CorporateCustomerResponse>listCorporateCustomer();
	
	CorporateCustomerResponse getById(int id);
	
	void addCorporateCustomer(CorporateCustomerRequest corporateCustomerRequest);
	
	void updateCorporateCustomer(int id,CorporateCustomerRequest corporateCustomerRequest);
	
	void delete(int id);
}
