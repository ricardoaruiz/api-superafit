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
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@ApiOperation(value = "doLogin", nickname = "doLogin")		
	@ApiResponses(value = { 
            @ApiResponse(code = 200, message = "OK", response = LoginResponse.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 500, message = "Internal Server Error")}) 
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<LoginResponse> doLogin(@RequestBody @Valid LoginRequest request) {	
		return ResponseEntity.ok(loginService.doLogin(request));
	}
	
}
