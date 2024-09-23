package com.kemalkeskin.bankCustomers.service.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kemalkeskin.bankCustomers.core.mapper.ModelMapperService;
import com.kemalkeskin.bankCustomers.model.IndividualCustomer;
import com.kemalkeskin.bankCustomers.repository.IndividualCustomerRepository;
import com.kemalkeskin.bankCustomers.service.abstracts.IndividualCustomerService;
import com.kemalkeskin.bankCustomers.service.dtoS.IndividualCustomerRequest;
import com.kemalkeskin.bankCustomers.service.dtoS.IndividualCustomerResponse;
import com.kemalkeskin.bankCustomers.service.rules.IndividualCustomerBusinessRules;

@Service
public class IndividualCustomerManager implements IndividualCustomerService {

	private IndividualCustomerRepository individualCustomerRepository;
	private ModelMapperService mapperService;
	private IndividualCustomerBusinessRules businessRules;

	public IndividualCustomerManager(IndividualCustomerRepository individualCustomerRepository,
			ModelMapperService mapperService,IndividualCustomerBusinessRules businessRules) {
		this.individualCustomerRepository = individualCustomerRepository;
		this.mapperService = mapperService;
		this.businessRules=businessRules;
	}

	@Override
	public List<IndividualCustomerResponse> listIndividualCustomer() {
		return individualCustomerRepository.findAll().stream()
				.map(customer -> mapperService.forResponse().map(customer, IndividualCustomerResponse.class))
				.collect(Collectors.toList());
	}

	@Override
	public IndividualCustomerResponse getById(int id) {
		this.businessRules.existsFoundId(id);
		IndividualCustomer individualCustomer=this.individualCustomerRepository.findById(id).get();
		return mapperService.forResponse().map(individualCustomer, IndividualCustomerResponse.class);
	}

	@Override
	public void addIndividualCustomer(IndividualCustomerRequest individualCustomerRequest) {
		this.businessRules.existsNationalId(individualCustomerRequest.getNationalId());
		IndividualCustomer addIndividualCustomer=this.mapperService.forRequest().map(individualCustomerRequest, IndividualCustomer.class);
		this.individualCustomerRepository.save(addIndividualCustomer);
		
		
	}

	@Override
	public void updateIndividualCustomer(int id, IndividualCustomerRequest individualCustomerRequest) {
		this.businessRules.existsFoundId(id);
		this.businessRules.existsNationalId(individualCustomerRequest.getNationalId());
		IndividualCustomer individualCustomer=this.mapperService.forRequest().map(individualCustomerRequest, IndividualCustomer.class);
		this.individualCustomerRepository.save(individualCustomer);
	}

	@Override
	public void deleteIndividualCustomer(int id) {
		this.businessRules.existsFoundId(id);
		this.individualCustomerRepository.deleteById(id);
		
	}

}
