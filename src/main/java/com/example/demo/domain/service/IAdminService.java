package com.example.demo.domain.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.pojo.AdminPojo;

public interface IAdminService {
	
List<AdminPojo> getAll();
	
	Optional<AdminPojo> getAdminById(Long id);
	
	Optional<AdminPojo> getAdminByEmail(String email);
	
	AdminPojo save(AdminPojo adminPojo);
	
	boolean deleteAdmin(Long id);

}
