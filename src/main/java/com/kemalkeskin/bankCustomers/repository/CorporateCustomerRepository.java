package com.kemalkeskin.bankCustomers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kemalkeskin.bankCustomers.model.CorporateCustomer;

@Repository
public interface CorporateCustomerRepository extends JpaRepository<CorporateCustomer, Integer>  {

	boolean existsByCompanyName(String companyName);
	boolean existsByTaxNumbers(String taxNumbers);
}
