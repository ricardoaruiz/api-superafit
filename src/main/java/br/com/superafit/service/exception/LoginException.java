package br.com.superafit.service.exception;

public class LoginException extends ServiceException {

	private static final long serialVersionUID = -8109741264142707498L;

	public LoginException() {
		super();
	}
	
	public LoginException(String message) {
		super(message);
	}

}
