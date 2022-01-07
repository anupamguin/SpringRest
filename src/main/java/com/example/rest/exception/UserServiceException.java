package com.example.rest.exception;

public class UserServiceException extends RuntimeException{
	
	public UserServiceException(String message) {
		super(message);
	}
}

class AppException extends RuntimeException{
	public AppException(String m) {
		super(m);
	}
}