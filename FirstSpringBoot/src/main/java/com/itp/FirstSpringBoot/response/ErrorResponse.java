package com.itp.FirstSpringBoot.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorResponse {

	private String error;
	private String errorMessage;
	private LocalDateTime timeStamp;
}
