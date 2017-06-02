package br.com.superafit.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the training database table.
 * 
 */
@Entity
@Table(name="training")
public class Training implements Serializable {

	private static final long serialVersionUID = -713714524851711030L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name="qt_round")
	private int qtRound;

	@ManyToOne
	@JoinColumn(name="training_type_id")
	private TrainingType trainingType;

	@OneToMany(mappedBy="training", cascade=CascadeType.ALL)
	private List<TrainingMovement> trainingMovements;

	public Training() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getQtRound() {
		return this.qtRound;
	}

	public void setQtRound(int qtRound) {
		this.qtRound = qtRound;
	}

	public TrainingType getTrainingType() {
		return this.trainingType;
	}

	public void setTrainingType(TrainingType trainingType) {
		this.trainingType = trainingType;
	}

	public List<TrainingMovement> getTrainingMovements() {
		return this.trainingMovements;
	}

	public void setTrainingMovements(List<TrainingMovement> trainingMovements) {
		this.trainingMovements = trainingMovements;
	}

	public TrainingMovement addTrainingMovement(TrainingMovement trainingMovement) {
		getTrainingMovements().add(trainingMovement);
		trainingMovement.setTraining(this);

		return trainingMovement;
	}

	public TrainingMovement removeTrainingMovement(TrainingMovement trainingMovement) {
		getTrainingMovements().remove(trainingMovement);
		trainingMovement.setTraining(null);

		return trainingMovement;
	}

}