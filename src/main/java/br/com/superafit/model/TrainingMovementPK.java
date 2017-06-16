package br.com.superafit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the training_movement database table.
 * 
 */
@Embeddable
public class TrainingMovementPK implements Serializable {

	private static final long serialVersionUID = 692607982322963889L;

	@Column(name="movement_id")
	private int movementId;

	@Column(name="training_id")
	private int trainingId;

	public TrainingMovementPK() {
	}
	public int getMovementId() {
		return this.movementId;
	}
	public void setMovementId(int movementId) {
		this.movementId = movementId;
	}
	public int getTrainingId() {
		return this.trainingId;
	}
	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TrainingMovementPK)) {
			return false;
		}
		TrainingMovementPK castOther = (TrainingMovementPK)other;
		return 
			(this.movementId == castOther.movementId)
			&& (this.trainingId == castOther.trainingId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.movementId;
		hash = hash * prime + this.trainingId;
		
		return hash;
	}
}