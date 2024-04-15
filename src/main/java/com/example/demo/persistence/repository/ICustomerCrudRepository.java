package com.example.demo.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.persistence.entity.Customer;

public interface ICustomerCrudRepository extends JpaRepository<Customer, Long>{
	
	 Optional<Customer> findByEmail(String email);

}
