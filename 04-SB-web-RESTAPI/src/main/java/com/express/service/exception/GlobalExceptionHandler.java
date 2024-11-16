package com.express.service.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotfoundException.class)
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ErrorAPI handleException(ResourceNotfoundException ex) {
		var errorApi = new ErrorAPI();
		errorApi.setDetails(ex.getMessage());
		errorApi.setTitle("Resource Not Found in Db");
		errorApi.setLocalDateTime(LocalDateTime.now());
		errorApi.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
		errorApi.setStatusCode(HttpStatus.BAD_REQUEST.value());
		return errorApi;
	
	}
	
	@ExceptionHandler(Exception.class)
	public ErrorAPI handleException(Exception ex) {
		
		var errorApi = new ErrorAPI();
		errorApi.setDetails(ex.getMessage());
		errorApi.setTitle("Something went Wrong");
		errorApi.setLocalDateTime(LocalDateTime.now());
	    //errorApi.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		errorApi.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		return errorApi;

	}
}
