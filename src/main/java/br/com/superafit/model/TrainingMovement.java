package br.com.superafit.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the training_movement database table.
 * 
 */
@Entity
@Table(name="training_movement")
public class TrainingMovement implements Serializable {

	private static final long serialVersionUID = 7907959901806905115L;

	@EmbeddedId
	private TrainingMovementPK id;

	@Column(name="qt_rep")
	private int qtRep;

	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@MapsId("movementId")
	@JoinColumn(name="movement_id")
	private Movement movement;

	@ManyToOne(cascade=CascadeType.PERSIST)
	@MapsId("trainingId")
	@JoinColumn(name="training_id")
	private Training training;

	public TrainingMovement() {
	}

	public TrainingMovementPK getId() {
		return this.id;
	}

	public void setId(TrainingMovementPK id) {
		this.id = id;
	}

	public int getQtRep() {
		return this.qtRep;
	}

	public void setQtRep(int qtRep) {
		this.qtRep = qtRep;
	}

	public Movement getMovement() {
		return this.movement;
	}

	public void setMovement(Movement movement) {
		this.movement = movement;
	}

	public Training getTraining() {
		return this.training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}

}