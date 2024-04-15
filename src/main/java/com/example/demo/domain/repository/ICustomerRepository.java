package com.example.demo.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.pojo.CustomerPojo;

public interface ICustomerRepository {

	List<CustomerPojo> getAll();
	
	Optional<CustomerPojo> getCustomerById(Long id);
	
	CustomerPojo saveCustomer(CustomerPojo customerPojoNew);
	
	Optional<CustomerPojo> getCustomerByEmail(String email);
	
	void deleteCustomer(Long id);
}
