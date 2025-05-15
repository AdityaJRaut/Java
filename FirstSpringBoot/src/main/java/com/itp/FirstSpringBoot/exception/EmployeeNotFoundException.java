package com.itp.FirstSpringBoot.exception;

import java.io.Serial;

public class EmployeeNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = 1L;
	
	public EmployeeNotFoundException(String errorMessage)
	{
		super(errorMessage);
	}
	
}
