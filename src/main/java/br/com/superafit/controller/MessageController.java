package br.com.superafit.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.superafit.controller.model.request.ResendMessageRequest;
import br.com.superafit.controller.model.request.SendMessageRequest;
import br.com.superafit.service.MessageService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("message")
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	@ApiOperation(value = "send", nickname = "send")		
	@ApiResponses(value = { 
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
	
	@RequestMapping(value="send", method=RequestMethod.POST)
	public ResponseEntity<Void> send(@RequestBody @Valid SendMessageRequest request) {
		messageService.send(request);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@ApiOperation(value = "resend", nickname = "resend")		
	@ApiResponses(value = { 
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 422, message = "Unprocessable Entity"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
	
	@RequestMapping(value="resend", method=RequestMethod.POST)
	public ResponseEntity<Void> resend(@RequestBody @Valid ResendMessageRequest request) {
		messageService.resend(request);
		return ResponseEntity.noContent().build();
	}
	
	
}
