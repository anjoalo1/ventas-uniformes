package com.example.demo.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.domain.pojo.CustomerPojo;
import com.example.demo.persistence.entity.Customer;


@Mapper(componentModel = "spring")
public interface ICustomerMapper {
	
	
	@Mapping(source="cardId", target="cardId")
	@Mapping(source="fullName", target="fullName")
	@Mapping(source="email", target="email")
	@Mapping(source="role", target="role")
	@Mapping(source="cellPhone", target="cellPhone")
	@Mapping(source="isActive", target="isActive")
	CustomerPojo toCustomerPojo(Customer customer);
	
	@InheritInverseConfiguration
    Customer toCustomer(CustomerPojo customerPojo);
	
	
	List<CustomerPojo> toCustomerPojo(List<Customer> customer);

}
