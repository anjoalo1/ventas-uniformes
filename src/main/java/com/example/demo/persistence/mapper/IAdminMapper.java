package com.example.demo.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.domain.pojo.AdminPojo;
import com.example.demo.persistence.entity.Admin;

@Mapper(componentModel="spring")
public interface IAdminMapper {
	
	@Mapping(source="cardId", target="cardId")
	@Mapping(source="fullName", target="fullName")
	@Mapping(source="address", target="address")
	@Mapping(source="email", target="email")
	@Mapping(source="role", target="role")
	@Mapping(source="password", target="password")
	@Mapping(source="cellPhone", target="cellPhone")
	@Mapping(source="isActive", target="isActive")
	AdminPojo toAdminPojo(Admin admin);
	
	@InheritInverseConfiguration
	Admin toAdmin(AdminPojo adminPojo);
	
	List<AdminPojo> toAdminPojo(List<Admin> admin);

}
