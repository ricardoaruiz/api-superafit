package br.com.superafit.service.exception;

public class MovementAlreadyExistsException extends ServiceException {

	private static final long serialVersionUID = -6766233612927488051L;

	public MovementAlreadyExistsException(String message) {
		super(message);
	}	
	
}
