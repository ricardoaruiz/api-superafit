package br.com.superafit.service.exception;

public class RegisterAlreadyExistsException extends ServiceException {

	private static final long serialVersionUID = -2736138790368300531L;

	public RegisterAlreadyExistsException(String message) {
		super(message);
	}
	
}
