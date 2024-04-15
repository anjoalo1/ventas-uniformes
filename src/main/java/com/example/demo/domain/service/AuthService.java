package com.example.demo.domain.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.domain.pojo.AdminPojo;
import com.example.demo.domain.pojo.AuthPojo;
import com.example.demo.domain.pojo.CustomerPojo;
import com.example.demo.domain.pojo.JwtPojo;
import com.example.demo.domain.repository.IAdminRepository;
import com.example.demo.domain.repository.ICustomerRepository;
import com.example.demo.exception.EmailValidationException;
import com.example.demo.security.JwtAuthenticationProvider;

@Service
public class AuthService implements IAuth{
	
	
	private final IAdminRepository iAdminRepository;
	private final JwtAuthenticationProvider jwtAuthenticationProvider;
	

	public AuthService(IAdminRepository iAdminRepository, JwtAuthenticationProvider jwtAuthenticationProvider) {
		this.iAdminRepository = iAdminRepository;
		this.jwtAuthenticationProvider = jwtAuthenticationProvider;
	}






	@Override
	public JwtPojo signIn(AuthPojo authPojo) {
		// TODO Auto-generated method stub
		 Optional<AdminPojo> pojo = iAdminRepository.getAdminByEmail(authPojo.getEmail());
		 
		 if(pojo.isEmpty()) {
			 throw EmailValidationException.noFoundEmail();
		 }else {
			 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			 if(!passwordEncoder.matches(authPojo.getPassword(),pojo.get().getPassword())) {
                 throw EmailValidationException.passwordInvalidate();
             }
		 }
		 
		return new JwtPojo(jwtAuthenticationProvider.createToken(pojo.get()));
	}

}
