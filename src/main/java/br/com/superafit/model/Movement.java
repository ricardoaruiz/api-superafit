package br.com.superafit.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the movement database table.
 * 
 */
@Entity
@Table(name="movement")
public class Movement implements Serializable {
	
	private static final long serialVersionUID = 1781463732378425756L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String description;

	private String name;

	private String translate;

	@OneToMany(mappedBy="movement")
	private List<TrainingMovement> trainingMovements;

	public Movement() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTranslate() {
		return this.translate;
	}

	public void setTranslate(String translate) {
		this.translate = translate;
	}

	public List<TrainingMovement> getTrainingMovements() {
		return this.trainingMovements;
	}

	public void setTrainingMovements(List<TrainingMovement> trainingMovements) {
		this.trainingMovements = trainingMovements;
	}

	public TrainingMovement addTrainingMovement(TrainingMovement trainingMovement) {
		getTrainingMovements().add(trainingMovement);
		trainingMovement.setMovement(this);

		return trainingMovement;
	}

	public TrainingMovement removeTrainingMovement(TrainingMovement trainingMovement) {
		getTrainingMovements().remove(trainingMovement);
		trainingMovement.setMovement(null);

		return trainingMovement;
	}

}