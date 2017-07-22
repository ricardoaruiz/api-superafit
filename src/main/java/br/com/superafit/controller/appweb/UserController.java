package br.com.superafit.controller.appweb;

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
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "createUser", nickname = "createUser")		
	@ApiResponses(value = { 
            @ApiResponse(code = 201, message = "Created", response = CreateUserResponse.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 422, message = "Unprocessable Entity"),
            @ApiResponse(code = 500, message = "Internal Server Error")}) 
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<CreateUserResponse> create(@RequestBody @Valid CreateUserRequest request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(
				new CreateUserResponse(userService.create(request)));
	}
	
}
