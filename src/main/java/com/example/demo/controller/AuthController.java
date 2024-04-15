package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.pojo.AuthPojo;
import com.example.demo.domain.pojo.JwtPojo;
import com.example.demo.domain.service.IAuth;

@RestController
@RequestMapping(path="/auth")
public class AuthController {
	
	private final IAuth iAuth;

	public AuthController(IAuth iAuth) {
		this.iAuth = iAuth;
	}
	
	@PostMapping(path="/sign-in")
	public ResponseEntity<JwtPojo> signIn(@RequestBody AuthPojo authPojo){
		return ResponseEntity.status(HttpStatus.OK).body(iAuth.signIn(authPojo));
	}
	
	

}
