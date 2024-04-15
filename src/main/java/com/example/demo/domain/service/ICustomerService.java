package com.example.demo.domain.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.pojo.CustomerPojo;

public interface ICustomerService {
	
List<CustomerPojo> getAll();
	
	Optional<CustomerPojo> getCustomerById(Long id);
	
	CustomerPojo saveCustomer(CustomerPojo customerPojoNew);
	
	boolean deleteCustomer(Long id);

}
