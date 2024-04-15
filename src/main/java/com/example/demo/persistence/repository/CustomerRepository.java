package com.example.demo.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.pojo.CustomerPojo;
import com.example.demo.domain.repository.ICustomerRepository;
import com.example.demo.persistence.entity.Customer;
import com.example.demo.persistence.mapper.ICustomerMapper;

@Repository
public class CustomerRepository implements ICustomerRepository{
	
	private final ICustomerMapper iCustomerMapper;
	private final ICustomerCrudRepository iCustomerCrudRepository;
	
	

	public CustomerRepository(ICustomerMapper iCustomerMapper, ICustomerCrudRepository iCustomerCrudRepository) {
		this.iCustomerMapper = iCustomerMapper;
		this.iCustomerCrudRepository = iCustomerCrudRepository;
	}

	@Override
	public List<CustomerPojo> getAll() {
		// TODO Auto-generated method stub
		return iCustomerMapper.toCustomerPojo(iCustomerCrudRepository.findAll());
	}

	@Override
	public Optional<CustomerPojo> getCustomerById(Long id) {
		// TODO Auto-generated method stub
		return iCustomerCrudRepository.findById(id).map(cus->iCustomerMapper.toCustomerPojo(cus));
	}
	
	public Optional<CustomerPojo> getCustomerByEmail(String email) {
		// TODO Auto-generated method stub
		return iCustomerCrudRepository.findByEmail(email).map(em->iCustomerMapper.toCustomerPojo(em));
	}

	@Override
	public CustomerPojo saveCustomer(CustomerPojo customerPojoNew) {
		// TODO Auto-generated method stub
		Customer customer = iCustomerMapper.toCustomer(customerPojoNew);
		return iCustomerMapper.toCustomerPojo(iCustomerCrudRepository.save(customer));
	}

	@Override
	public void deleteCustomer(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
