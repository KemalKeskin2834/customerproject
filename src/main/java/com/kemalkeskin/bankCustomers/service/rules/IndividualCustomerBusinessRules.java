package com.kemalkeskin.bankCustomers.service.rules;


import org.springframework.stereotype.Service;

import com.kemalkeskin.bankCustomers.core.exception.BusinessException;
import com.kemalkeskin.bankCustomers.repository.IndividualCustomerRepository;
@Service
public class IndividualCustomerBusinessRules {
	
	private IndividualCustomerRepository individualCustomerRepository;


	public IndividualCustomerBusinessRules(IndividualCustomerRepository individualCustomerRepository) {
		this.individualCustomerRepository = individualCustomerRepository;
	
	}
	
	
	public void existsFoundId(int id) {
		if(!individualCustomerRepository.existsById(id)) {
			throw new BusinessException("don't found id= "+id);
		}
	}
	
	
	public void existsNationalId(String nationalId) {
		if(individualCustomerRepository.existsByNationalId(nationalId)) {
			throw new BusinessException("this column uniqe.This national Id is available in the system");
		}
	}
	

	

}
