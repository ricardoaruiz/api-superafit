package br.com.superafit.controller.model.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.superafit.model.Training;

public class GetDayTrainingResponse implements Serializable {

	private static final long serialVersionUID = -5465418877161987228L;

	private List<DayTrainingDataResponse> data;
	
	@JsonIgnore
	private List<Training> trainings;
			
	public GetDayTrainingResponse(List<Training> trainings) {
		this.trainings = trainings;
	}

	public List<DayTrainingDataResponse> getData() {
		
		if(hasTraining()) {
			data = new ArrayList<>();
			for (Training training : trainings) {
				data.add(new DayTrainingDataResponse(training));
			}
		}
		
		return data;
	}
	
	public boolean hasTraining() {
		return trainings != null && !trainings.isEmpty();
	}
	
}
