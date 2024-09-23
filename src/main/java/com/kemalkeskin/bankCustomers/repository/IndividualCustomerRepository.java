package com.kemalkeskin.bankCustomers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kemalkeskin.bankCustomers.model.IndividualCustomer;

@Repository
public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomer, Integer> {

	boolean existsByNationalId(String nationalId);
}
