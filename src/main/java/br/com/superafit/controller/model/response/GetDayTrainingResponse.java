package br.com.superafit.controller.model.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.superafit.model.Movement;
import br.com.superafit.model.Training;
import br.com.superafit.model.TrainingMovement;
import br.com.superafit.utils.DateFormatUtil;

public class GetDayTrainingResponse implements Serializable {

	private static final long serialVersionUID = -5465418877161987228L;

	@JsonIgnore
	private Training training;
			
	public GetDayTrainingResponse(Training training) {
		this.training = training;
	}
	
	public String getDate() {
		if(hasTraining() && this.training.getDate() != null) {
			return DateFormatUtil.toString(this.training.getDate(), DateFormatUtil.Format.DIA_MES_ANO);
		}
		return null;
	}

	public String getType() {
		if(hasTraining() && this.training.getTrainingType() != null) {
			return this.training.getTrainingType().getName();
		}
		return null;
	
	}

	public Integer getRound() {
		if(hasTraining()) {
			return this.training.getQtRound();
		}
		return null;
	}

	public List<DayTrainingMovementResponse> getMovements() {
		List<DayTrainingMovementResponse> toReturn = null;
		if(hasMoviments()) {
			toReturn = new ArrayList<DayTrainingMovementResponse>();
			for (TrainingMovement trainingMovement : this.training.getTrainingMovements()) {
				DayTrainingMovementResponse dm = new DayTrainingMovementResponse();
				Movement movement = trainingMovement.getMovement();
				dm.setName(movement.getName());
				dm.setTranslate(movement.getTranslate());
				dm.setDescription(movement.getDescription());
				dm.setQtRep(trainingMovement.getQtRep());
				toReturn.add(dm);
			}
		}
		return toReturn;
	}
	
	public boolean hasTraining() {
		return this.training != null;
	}
	
	private boolean hasMoviments() {
		return hasTraining() && this.training.getTrainingMovements() != null && !this.training.getTrainingMovements().isEmpty();
	}
	
}
