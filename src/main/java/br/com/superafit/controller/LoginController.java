package br.com.superafit.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.superafit.controller.model.request.LoginRequest;
import br.com.superafit.controller.model.response.LoginResponse;
import br.com.superafit.service.LoginService;

@RestController
@RequestMapping("login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<LoginResponse> doLogin(@RequestBody @Valid LoginRequest request) {	
		return ResponseEntity.ok(loginService.doLogin(request));
	}
	
}
