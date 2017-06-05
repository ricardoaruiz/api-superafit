package br.com.superafit.controller.model.response;

import java.io.Serializable;

public class DayTrainingMovementResponse extends MovementResponse implements Serializable {

	private static final long serialVersionUID = 5789286705172008296L;
	
	private int qtRep;

	public int getQtRep() {
		return qtRep;
	}

	public void setQtRep(int qtRep) {
		this.qtRep = qtRep;
	}

}
