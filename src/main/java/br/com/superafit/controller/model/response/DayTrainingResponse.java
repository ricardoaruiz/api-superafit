package br.com.superafit.controller.model.response;

import java.io.Serializable;
import java.util.List;

public class DayTrainingResponse implements Serializable {

	private static final long serialVersionUID = -5465418877161987228L;

	private String date;
	
	private String type;
	
	private int round;
	
	private List<MovementResponse> movements;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public List<MovementResponse> getMovements() {
		return movements;
	}

	public void setMovements(List<MovementResponse> movements) {
		this.movements = movements;
	}
	
}
