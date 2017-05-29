package br.com.superafit.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.superafit.controller.model.request.CreateUserRequest;
import br.com.superafit.controller.model.response.CreateUserResponse;
import br.com.superafit.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<CreateUserResponse> create(@RequestBody @Valid CreateUserRequest request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(
				new CreateUserResponse(userService.create(request)));
	}
	
}
