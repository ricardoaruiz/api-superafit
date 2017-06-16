package br.com.superafit.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.superafit.controller.model.request.CreateDayTrainingRequest;
import br.com.superafit.controller.model.response.GetDayTrainingResponse;
import br.com.superafit.controller.model.response.ListScheduleResponse;
import br.com.superafit.service.DayTrainingService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("day-training")
public class DayTrainingController {

	@Autowired
	private DayTrainingService trainingDayService;
		
	@ApiOperation(value = "getTraining", nickname = "getTraining")		
	@ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Ok", response = ListScheduleResponse.class),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 500, message = "Internal Server Error")}) 
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<GetDayTrainingResponse> getDayTraining(
			@RequestParam(value="date", required=true)
			@DateTimeFormat(pattern="dd/MM/yyyy")
			Date date) {
		
		GetDayTrainingResponse response = new GetDayTrainingResponse(trainingDayService.getDayTraining(date));		
		return !response.hasTraining() ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
	}
	
	@ApiOperation(value = "create", nickname = "create")		
	@ApiResponses(value = { 
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody @Valid CreateDayTrainingRequest request) {		
		trainingDayService.create(request);	
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@ApiOperation(value = "notification", nickname = "notification")
	@ApiResponses(value = { 
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
	
	@RequestMapping(value="notification", method = RequestMethod.POST)
	public ResponseEntity<Void> notification() {
		
		trainingDayService.sendNotification();		
		return ResponseEntity.noContent().build();
	}
}
