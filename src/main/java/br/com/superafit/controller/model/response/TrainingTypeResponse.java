package br.com.superafit.controller.model.response;

import java.io.Serializable;

import br.com.superafit.model.TrainingType;

public class TrainingTypeResponse implements Serializable {

	private static final long serialVersionUID = -4005586406439290363L;

	private TrainingType trainingType;

	public TrainingTypeResponse(TrainingType trainingType) {
		this.trainingType = trainingType;
	}
	
	public Long getId() {
		return this.trainingType.getId();
	}

	public String getName() {
		return this.trainingType.getName();
	}

	public Integer getSequence() {
		return this.trainingType.getSequence();
	}
	
}
