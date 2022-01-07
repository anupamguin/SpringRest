package com.example.rest.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value= {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception ex,WebRequest request){
		
		String errorMessage =ex.getLocalizedMessage();
		if(errorMessage == null) errorMessage=ex.toString();
		ErrorMessage em =new ErrorMessage(new Date(),errorMessage);
		
		return new ResponseEntity<>(em,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// For multiple exception
	@ExceptionHandler(value= {NullPointerException.class,ArithmeticException.class})
	public ResponseEntity<Object> handleNullException(Exception ex,WebRequest request){
		System.err.println("Null Pointer");
		String errorMessage =ex.getLocalizedMessage();
		if(errorMessage == null) errorMessage=ex.toString();
		ErrorMessage em =new ErrorMessage(new Date(),errorMessage);
		
		return new ResponseEntity<>(em,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value= {UserServiceException.class})
	public ResponseEntity<Object> handleUserException(UserServiceException ex,WebRequest request){
		System.err.println("user Pointer");
		String errorMessage =ex.getLocalizedMessage();
		if(errorMessage == null) errorMessage=ex.toString();
		ErrorMessage em =new ErrorMessage(new Date(),errorMessage);
		
		return new ResponseEntity<>(em,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
