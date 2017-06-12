package br.com.superafit.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the training database table.
 * 
 */
@Entity
@Table(name="training")
public class Training implements Serializable {

	private static final long serialVersionUID = 5710573675403180280L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name="qt_round")
	private int qtRound;

	@Column(name="description")
	private String description;
	
	@Column(name="sequence")
	private int sequence;
	
	@ManyToOne
	@JoinColumn(name="training_type_id")
	private TrainingType trainingType;

	@OneToMany(mappedBy="training", fetch=FetchType.EAGER)
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
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public TrainingType getTrainingType() {
		return this.trainingType;
	}

	public void setTrainingType(TrainingType trainingType) {
		this.trainingType = trainingType;
	}

	public List<TrainingMovement> getTrainingMovements() {
		if(this.trainingMovements == null) {
			this.trainingMovements = new ArrayList<>();
		}
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