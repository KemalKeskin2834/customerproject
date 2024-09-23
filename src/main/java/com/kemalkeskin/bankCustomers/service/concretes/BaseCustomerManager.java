package com.kemalkeskin.bankCustomers.service.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kemalkeskin.bankCustomers.model.BaseCustomer;
import com.kemalkeskin.bankCustomers.repository.BaseCustomerRepository;
import com.kemalkeskin.bankCustomers.service.abstracts.BaseCustomerService;

@Service
public class BaseCustomerManager implements BaseCustomerService{

	private BaseCustomerRepository baseCustomerRepository;

	public BaseCustomerManager(BaseCustomerRepository baseCustomerRepository) {
		this.baseCustomerRepository = baseCustomerRepository;
	}

	@Override
	public List<BaseCustomer> listCustomers() {
		
		return baseCustomerRepository.findAll();
	}

	@Override
	public BaseCustomer getById(int id) {
	
		return baseCustomerRepository.findById(id).get();
	}
	
	
	
}
