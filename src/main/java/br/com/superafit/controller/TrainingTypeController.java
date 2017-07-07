package br.com.superafit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.superafit.controller.model.response.TrainingTypeResponse;
import br.com.superafit.model.TrainingType;
import br.com.superafit.service.TrainingTypeService;

@RestController
@RequestMapping("trainning-type")
public class TrainingTypeController {

	@Autowired
	private TrainingTypeService trainingTypeService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<TrainingTypeResponse>> list() {
		List<TrainingType> trainingTypes = trainingTypeService.findAll();
		return trainingTypes == null || trainingTypes.isEmpty() ? 
				ResponseEntity.noContent().build() :
				ResponseEntity.ok(getTrainingTypeResponse(trainingTypes));
	}

	private List<TrainingTypeResponse> getTrainingTypeResponse(List<TrainingType> trainingTypes) {
		List<TrainingTypeResponse> toReturn = new ArrayList<TrainingTypeResponse>();
		for (TrainingType trainingType : trainingTypes) {
			toReturn.add(new TrainingTypeResponse(trainingType));
		}
		return toReturn;
	}
	
}
