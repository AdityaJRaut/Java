package com.itp.FirstSpringBoot.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationErrorResponse {

	private String message;
	private String rejectedField;
	private Object rejectedValue;
}
