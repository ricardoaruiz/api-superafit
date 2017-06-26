package br.com.superafit.service.exception;

public class MessageNotFoundException extends ServiceException {

	private static final long serialVersionUID = -4259138164212155072L;

	public MessageNotFoundException(String message) {
		super(message);
	}
	
}
