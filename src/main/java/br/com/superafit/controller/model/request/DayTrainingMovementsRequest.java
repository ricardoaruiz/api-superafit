package br.com.superafit.controller.model.request;

import java.io.Serializable;

public class DayTrainingMovementsRequest implements Serializable {

	private static final long serialVersionUID = -425189038663878427L;

	private int movement;
	
	private int repetition;

	public int getMovement() {
		return movement;
	}

	public void setMovement(int movement) {
		this.movement = movement;
	}

	public int getRepetition() {
		return repetition;
	}

	public void setRepetition(int repetition) {
		this.repetition = repetition;
	}
	
}
