package com.example.demo.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.domain.pojo.AdminPojo;
import com.example.demo.domain.repository.IAdminRepository;
import com.example.demo.exception.EmailValidationException;

@Service
public class AdminService implements IAdminService{
	
	private final IAdminRepository iAdminRepository;

	public AdminService(IAdminRepository iAdminRepository) {
		this.iAdminRepository = iAdminRepository;
	}

	@Override
	public List<AdminPojo> getAll() {
		// TODO Auto-generated method stub
		return iAdminRepository.getAll();
	}

	@Override
	public Optional<AdminPojo> getAdminById(Long id) {
		// TODO Auto-generated method stub
		return iAdminRepository.getAdminById(id);
	}

	@Override
	public Optional<AdminPojo> getAdminByEmail(String email) {
		// TODO Auto-generated method stub
		return iAdminRepository.getAdminByEmail(email);
	}

	@Override
	public AdminPojo save(AdminPojo adminPojo) {
		// TODO Auto-generated method stub
		Optional<AdminPojo> adminFind = iAdminRepository.getAdminByEmail(adminPojo.getEmail());
		if(adminFind.isPresent()) {
			throw EmailValidationException.emailExist();
		}else {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			adminPojo.setPassword(passwordEncoder.encode(adminPojo.getPassword()));
			adminPojo.setRole("ADMIN");
			adminPojo.setIsActive(1);
			return iAdminRepository.save(adminPojo);
		}
		
	}

	@Override
	public boolean deleteAdmin(Long id) {
		// TODO Auto-generated method stub
		try {
			iAdminRepository.deleteAdmin(id);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	

}
