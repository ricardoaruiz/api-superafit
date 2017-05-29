package br.com.superafit.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.superafit.controller.model.request.CreateUserRequest;
import br.com.superafit.enumeration.MessageCodeEnum;
import br.com.superafit.model.User;
import br.com.superafit.repository.UserRepository;
import br.com.superafit.service.exception.InvalidPasswordException;
import br.com.superafit.service.exception.LoginAlreadExistsExcption;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public String create(CreateUserRequest createUser) {
		
		if(!createUser.getPassword1().equals(createUser.getPassword2())) {
			throw new InvalidPasswordException(MessageCodeEnum.CREATE_USER_WRONG_PASSWORD.getCode());
		}
		
		if(userRepository.findByLogin(createUser.getLogin()) != null) {
			throw new LoginAlreadExistsExcption(MessageCodeEnum.CREATE_USER_LOGIN_ALREAD_EXISTS.getCode());
		}
				
		User user = userRepository.save(getUser(createUser));		
		return user.getId();
	}
	
	private User getUser(CreateUserRequest createUser) {
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setLogin(createUser.getLogin());
		user.setPassword(createUser.getPassword1());
		return user;
	}
	
}
