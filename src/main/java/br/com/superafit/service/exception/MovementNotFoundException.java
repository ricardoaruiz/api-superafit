package br.com.superafit.service.exception;

public class MovementNotFoundException extends ServiceException {

	private static final long serialVersionUID = -2754918987466169442L;

	public MovementNotFoundException(String message) {
		super(message);
	}	
	
}
