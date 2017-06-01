package br.com.superafit.controller.model.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CreateDayTrainingRequest implements Serializable {
	
	private static final long serialVersionUID = 3286240843984490189L;

	@JsonFormat(pattern = "dd-MM-yyyy", locale = "pt-BR", timezone = "Brazil/East")
	private Date training_date;
	
	private int training_type;
	
	private int training_round;
	
	private List<DayTrainingMovementsRequest> movements;

	public Date getTraining_date() {
		return training_date;
	}

	public void setTraining_date(Date training_date) {
		this.training_date = training_date;
	}

	public int getTraining_type() {
		return training_type;
	}

	public void setTraining_type(int training_type) {
		this.training_type = training_type;
	}

	public int getTraining_round() {
		return training_round;
	}

	public void setTraining_round(int training_round) {
		this.training_round = training_round;
	}

	public List<DayTrainingMovementsRequest> getMovements() {
		return movements;
	}

	public void setMovements(List<DayTrainingMovementsRequest> movements) {
		this.movements = movements;
	}
	
}
