package com.kemalkeskin.bankCustomers.core.mapper;

import org.modelmapper.ModelMapper;


public interface ModelMapperService {

	ModelMapper forResponse();
	ModelMapper forRequest();
}
