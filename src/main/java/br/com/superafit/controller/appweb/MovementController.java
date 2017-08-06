package br.com.superafit.controller.appweb;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.superafit.controller.model.request.CreateMovementRequest;
import br.com.superafit.controller.model.request.FindMovementRequest;
import br.com.superafit.controller.model.request.FindMovementResponse;
import br.com.superafit.controller.model.request.MovementResponse;
import br.com.superafit.model.Movement;
import br.com.superafit.service.MovementService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("movement")
public class MovementController {

	@Autowired
	private MovementService movementService;
		
	@ApiOperation(value = "create", nickname = "create")		
	@ApiResponses(value = { 
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 422, message = "Unprocessable Entity"),
            @ApiResponse(code = 500, message = "Internal Server Error")}) 
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody @Valid CreateMovementRequest request) {		
		movementService.save(request);		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@ApiOperation(value = "getOne", nickname = "getOne")		
	@ApiResponses(value = { 
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 500, message = "Internal Server Error")}) 
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<MovementResponse> getOne(@PathVariable(name="id") Long id) {
		MovementResponse response = new MovementResponse(movementService.getMovement(id));		
		return response != null ? ResponseEntity.ok(response) : ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "findAllActived", nickname = "findAllActived")		
	@ApiResponses(value = { 
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 500, message = "Internal Server Error")}) 
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<FindMovementResponse> findAllActived(FindMovementRequest request) {
		FindMovementResponse response = new FindMovementResponse(movementService.findAllActive(request.getName()));		
		return response.hasMovements() ? ResponseEntity.ok(response) : ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "findAll", nickname = "findAll")		
	@ApiResponses(value = { 
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 500, message = "Internal Server Error")}) 
	
	@RequestMapping(value="all", method=RequestMethod.GET)
	public ResponseEntity<FindMovementResponse> find(FindMovementRequest request) {
		FindMovementResponse response = new FindMovementResponse(movementService.findAll(request.getName()));		
		return response.hasMovements() ? ResponseEntity.ok(response) : ResponseEntity.noContent().build();
	}	
	
}
