package br.com.superafit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.superafit.service.exception.LoginException;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(LoginException.class)
	public ResponseEntity<Void> loginException(LoginException e) {		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();		
	}
	
}
