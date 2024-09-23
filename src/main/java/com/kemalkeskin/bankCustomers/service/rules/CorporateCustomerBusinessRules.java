package com.kemalkeskin.bankCustomers.service.rules;

import org.springframework.stereotype.Service;

import com.kemalkeskin.bankCustomers.core.exception.BusinessException;
import com.kemalkeskin.bankCustomers.repository.CorporateCustomerRepository;

@Service
public class CorporateCustomerBusinessRules {
	
	private CorporateCustomerRepository customerRepository;
	
	public CorporateCustomerBusinessRules(CorporateCustomerRepository customerRepository) {
		this.customerRepository=customerRepository;
	}
	
	public void existsFoundId(int id) {
		if(!customerRepository.existsById(id)) {
			throw new BusinessException("don't found id= "+id);
		}
	}
	
	public void checkİfCompanyName(String CompanyName) {
		if(customerRepository.existsByCompanyName(CompanyName)) {
			throw new BusinessException("this company name avaliable.");
		}
	}
	
	public void checkİfTaxNumbers(String taxNumbers) {
		if(this.customerRepository.existsByTaxNumbers(taxNumbers)) {
			throw new BusinessException("this column uniqe.This tax numbers is available in the system.");
		}
	}

}
