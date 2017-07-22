package br.com.superafit.controller.appweb;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.superafit.controller.model.request.CreateScheduleRequest;
import br.com.superafit.controller.model.request.RemoveScheduleRequest;
import br.com.superafit.controller.model.response.ListScheduleResponse;
import br.com.superafit.service.ScheduleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("schedule")
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;
	
	@ApiOperation(value = "create", nickname = "create")		
	@ApiResponses(value = { 
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 422, message = "Unprocessable Entity"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody @Valid CreateScheduleRequest request) {
		scheduleService.insert(request);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@ApiOperation(value = "list", nickname = "list")		
	@ApiResponses(value = { 
            @ApiResponse(code = 200, message = "OK", response = ListScheduleResponse.class),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 500, message = "Internal Server Error")}) 
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<ListScheduleResponse> list() {
		ListScheduleResponse schedules = scheduleService.list();
		return schedules == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(schedules);
	}

	@ApiOperation(value = "remove", nickname = "remove")		
	@ApiResponses(value = { 
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 422, message = "Unprocessable Entity"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Void> remove(@RequestBody @Valid RemoveScheduleRequest request) {
		scheduleService.remove(request);	
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "notification", nickname = "notification")		
	@ApiResponses(value = { 
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
	
	@RequestMapping(value="notification", method = RequestMethod.POST)
	public ResponseEntity<Void> notification() {		
		scheduleService.sendScheduleNotification();		
		return ResponseEntity.noContent().build();
	}
	
}
