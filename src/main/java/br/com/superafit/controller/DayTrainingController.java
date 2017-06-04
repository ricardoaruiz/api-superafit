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
import br.com.superafit.controller.model.response.DayTrainingResponse;
import br.com.superafit.service.DayTrainingService;

@RestController
@RequestMapping("day-training")
public class DayTrainingController {

	@Autowired
	private DayTrainingService trainingDayService;
		
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<DayTrainingResponse> getDayTraining(
			@RequestParam(value="date", required=true)
			@DateTimeFormat(pattern="dd/MM/yyyy")
			Date date) {
		DayTrainingResponse dayTraining = trainingDayService.getDayTraining(date);
		
		if(dayTraining == null) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(dayTraining);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody @Valid CreateDayTrainingRequest request) {		
		trainingDayService.create(request);		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
}
