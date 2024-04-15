package com.example.demo.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.pojo.AdminPojo;

public interface IAdminRepository {
	
	
	List<AdminPojo> getAll();
	
	Optional<AdminPojo> getAdminById(Long id);
	
	Optional<AdminPojo> getAdminByEmail(String email);
	
	AdminPojo save(AdminPojo adminPojo);
	
	void deleteAdmin(Long id);

}
