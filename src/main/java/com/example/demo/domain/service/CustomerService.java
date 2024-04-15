package com.example.demo.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.domain.pojo.CustomerPojo;
import com.example.demo.domain.repository.ICustomerRepository;

@Service
public class CustomerService implements ICustomerService{

	private final ICustomerRepository  iCustomerRepository;
	
	
	
	public CustomerService(ICustomerRepository iCustomerRepository) {
		this.iCustomerRepository = iCustomerRepository;
	}

	@Override
	public List<CustomerPojo> getAll() {
		// TODO Auto-generated method stub
		return iCustomerRepository.getAll();
	}

	@Override
	public Optional<CustomerPojo> getCustomerById(Long id) {
		// TODO Auto-generated method stub
		return iCustomerRepository.getCustomerById(id);
	}

	@Override
	public CustomerPojo saveCustomer(CustomerPojo customerPojoNew) {
		// TODO Auto-generated method stub
		return iCustomerRepository.saveCustomer(customerPojoNew);
	}

	@Override
	public boolean deleteCustomer(Long id) {
		// TODO Auto-generated method stub
		try {
			iCustomerRepository.deleteCustomer(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}


}
