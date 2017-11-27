package com.ohio.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(StudentNotFoundException.class)
	public void printException(){
	System.out.println("Student not Found!!!");
	}
	
	@ExceptionHandler(Exception.class)
	public void printGenericException(){
	System.out.println("There was some exception ....");
	}

	
}
