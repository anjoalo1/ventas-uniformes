package com.example.demo.exception;

public class EmailValidationException extends RuntimeException{

	public EmailValidationException(String message) {
		super(message);
	}
	
	public static EmailValidationException noFoundEmail() {
		return new EmailValidationException("No found email");
	}
	
	public static EmailValidationException passwordInvalidate() {
		return new EmailValidationException("Password no validate");
	}
	
	public static EmailValidationException emailExist() {
		return new EmailValidationException("Email already exists");
	}
}
