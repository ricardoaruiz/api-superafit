package br.com.superafit.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the training_type database table.
 * 
 */
@Entity
@Table(name="training_type")
public class TrainingType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String name;

	//bi-directional many-to-one association to Training
	@OneToMany(mappedBy="trainingType")
	private List<Training> trainings;

	public TrainingType() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Training> getTrainings() {
		return this.trainings;
	}

	public void setTrainings(List<Training> trainings) {
		this.trainings = trainings;
	}

	public Training addTraining(Training training) {
		getTrainings().add(training);
		training.setTrainingType(this);

		return training;
	}

	public Training removeTraining(Training training) {
		getTrainings().remove(training);
		training.setTrainingType(null);

		return training;
	}

}