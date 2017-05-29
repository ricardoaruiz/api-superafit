package br.com.superafit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.superafit.controller.model.request.LoginRequest;
import br.com.superafit.controller.model.response.LoginResponse;
import br.com.superafit.model.User;
import br.com.superafit.repository.UserRepository;
import br.com.superafit.service.exception.LoginException;

@Service
public class LoginService {


	@Autowired
	private UserRepository userRepository;
	
	public LoginResponse doLogin(LoginRequest loginData) {
				
		User user = userRepository.findByLoginAndPassword(loginData.getLogin(), loginData.getPassword());
		
		if(user == null) {
			throw new LoginException();			
		}
		
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setUserId(user.getId());		
		return loginResponse;
		
	}
	
}
