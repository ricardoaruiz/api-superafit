package br.com.superafit.service.exception;

public class LoginAlreadExistsExcption extends ServiceException {

	private static final long serialVersionUID = 3795681564444858480L;

	public LoginAlreadExistsExcption(String message) {
		super(message);
	}
	
}
