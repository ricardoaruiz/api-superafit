package br.com.superafit.service;

import org.springframework.stereotype.Service;

import br.com.superafit.controller.model.request.LoginRequest;
import br.com.superafit.controller.model.response.LoginResponse;
import br.com.superafit.service.exception.LoginException;

@Service
public class LoginService {

	private static final String USER_NOT_FOUND = "user1";

	public LoginResponse doLogin(LoginRequest loginData) {
		
		LoginResponse loginResponse = new LoginResponse();
		
		switch (loginData.getLogin()) {
		case USER_NOT_FOUND:
//			loginResponse.setCode(ServiceConstants.LoginConstants.USER_NOT_FOUND);
//			loginResponse.setMessage("Usuário não cadastrado.");
			throw new LoginException();
			
		default:
			loginResponse.setCode(ServiceConstants.LoginConstants.USER_LOGIN_SUCCESS);
			loginResponse.setMessage("Login realizado com sucesso.");			
			break;
		}

		
		return loginResponse;
		
	}
	
}