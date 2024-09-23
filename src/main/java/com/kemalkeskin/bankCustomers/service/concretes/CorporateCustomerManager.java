package com.kemalkeskin.bankCustomers.service.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kemalkeskin.bankCustomers.core.mapper.ModelMapperService;
import com.kemalkeskin.bankCustomers.model.CorporateCustomer;
import com.kemalkeskin.bankCustomers.repository.CorporateCustomerRepository;
import com.kemalkeskin.bankCustomers.service.abstracts.CorporateCustomerService;
import com.kemalkeskin.bankCustomers.service.dtoS.CorporateCustomerRequest;
import com.kemalkeskin.bankCustomers.service.dtoS.CorporateCustomerResponse;
import com.kemalkeskin.bankCustomers.service.rules.CorporateCustomerBusinessRules;

@Service
public class CorporateCustomerManager implements CorporateCustomerService {

	private CorporateCustomerRepository corporateCustomerRepository;
	private ModelMapperService mapperService;
	private CorporateCustomerBusinessRules businessRules;

	public CorporateCustomerManager(CorporateCustomerRepository corporateCustomerRepository,
			ModelMapperService mapperService, CorporateCustomerBusinessRules businessRules) {
		this.corporateCustomerRepository = corporateCustomerRepository;
		this.mapperService = mapperService;
		this.businessRules = businessRules;
	}

	@Override
	public List<CorporateCustomerResponse> listCorporateCustomer() {
		List<CorporateCustomer> customers = this.corporateCustomerRepository.findAll();
		List<CorporateCustomerResponse> listCustomers = customers.stream()
				.map(customer -> this.mapperService.forResponse().map(customer, CorporateCustomerResponse.class))
				.collect(Collectors.toList());
		return listCustomers;
	}

	@Override
	public CorporateCustomerResponse getById(int id) {
		this.businessRules.existsFoundId(id);
		CorporateCustomer corporateCustomer = corporateCustomerRepository.findById(id).get();
		return mapperService.forResponse().map(corporateCustomer, CorporateCustomerResponse.class);
	}

	@Override
	public void addCorporateCustomer(CorporateCustomerRequest corporateCustomerRequest) {
	this.businessRules.checkİfCompanyName(corporateCustomerRequest.getCompanyName());
	this.businessRules.checkİfTaxNumbers(corporateCustomerRequest.getTaxNumbers());
		CorporateCustomer addCorporateCustomer = this.mapperService.forRequest().map(corporateCustomerRequest,
				CorporateCustomer.class);
		this.corporateCustomerRepository.save(addCorporateCustomer);

	}

	@Override
	public void updateCorporateCustomer(int id, CorporateCustomerRequest corporateCustomerRequest) {
		this.businessRules.existsFoundId(id);
		this.businessRules.checkİfCompanyName(corporateCustomerRequest.getCompanyName());

		CorporateCustomer updateCorporateCustomer = this.mapperService.forRequest().map(corporateCustomerRequest,
				CorporateCustomer.class);
		this.corporateCustomerRepository.save(updateCorporateCustomer);
	}

	@Override
	public void delete(int id) {
		this.businessRules.existsFoundId(id);
		this.corporateCustomerRepository.deleteById(id);
	}

}
