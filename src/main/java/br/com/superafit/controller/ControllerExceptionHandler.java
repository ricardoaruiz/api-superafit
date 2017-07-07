package br.com.superafit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.superafit.controller.model.response.ErrorResponse;
import br.com.superafit.controller.model.response.ErrorsResponse;
import br.com.superafit.service.exception.LoginException;
import br.com.superafit.service.exception.ServiceException;

@ControllerAdvice
public class ControllerExceptionHandler {

	private final Logger LOG = LoggerFactory.getLogger(ControllerExceptionHandler.class);
	
	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Void> genericError(Exception e) {
		LOG.error("GenericError: ", e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); 
	}
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<Void> loginException(LoginException e) {		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();		
	}

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<ErrorsResponse> serviceValidation(ServiceException e) {		
		ErrorsResponse response = new ErrorsResponse();		
		response.addErrors(new ErrorResponse(getMessage(e.getMessage())));		
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorsResponse> dataValidation(MethodArgumentNotValidException e) {
		
		ErrorsResponse response = new ErrorsResponse();
		
		BindingResult bindingResult = e.getBindingResult();
		for (ObjectError error : bindingResult.getAllErrors()) {
			response.addErrors(new ErrorResponse(getMessage(error.getDefaultMessage())));
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	private String getMessage(String key) {
		try {
			return messageSource.getMessage(key, null, LocaleContextHolder.getLocaleContext().getLocale());
		} catch(Exception e) {
			return "";
		}
	}
	
}
