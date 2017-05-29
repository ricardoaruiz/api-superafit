package br.com.superafit.service.exception;

public class InvalidPasswordException extends ServiceException {

	private static final long serialVersionUID = 3292757040004648726L;

	public InvalidPasswordException(String message) {
		super(message);
	}
	
	
}
