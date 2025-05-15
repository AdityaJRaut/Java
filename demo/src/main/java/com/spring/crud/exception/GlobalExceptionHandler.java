package com.spring.crud.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.crud.response.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleStudentNotFoundException(StudentNotFoundException ex)
	{
		return new ResponseEntity<ErrorResponse>(new ErrorResponse("Student not found",ex.getMessage(),LocalDateTime.now()),HttpStatus.NOT_FOUND);
	}
}
