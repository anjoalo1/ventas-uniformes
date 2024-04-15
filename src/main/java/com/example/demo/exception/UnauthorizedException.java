package com.example.demo.exception;

public class UnauthorizedException extends RuntimeException{

	
	public UnauthorizedException(String message) {
		super (message);
		
	}
	
	public static UnauthorizedException noAuthorized() {
		
		return new UnauthorizedException("Token no validate");
	}
}
