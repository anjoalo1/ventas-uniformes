package com.example.demo.persistence.repository; 

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.persistence.entity.Admin;

public interface IAdminCrudRepository extends JpaRepository<Admin, Long>{
	
	Optional<Admin> findAdminByEmail(String email);

}
