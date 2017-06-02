package br.com.superafit.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.superafit.controller.model.request.CreateDayTrainingRequest;
import br.com.superafit.controller.model.response.DayTrainingResponse;
import br.com.superafit.service.DayTrainingService;

@RestController
@RequestMapping("day-trainig")
public class DayTrainingController {

	@Autowired
	private DayTrainingService trainingDayService;
		
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<DayTrainingResponse> getLastTrainigDay() {
		return ResponseEntity.ok(trainingDayService.getLastTrainingDayResponse());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody @Valid CreateDayTrainingRequest request) {		
		trainingDayService.create(request);		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
}
