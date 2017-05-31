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
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date date;

	//uni-directional many-to-many association to Movement
	@ManyToMany
	@JoinTable(
		name="training_movement"
		, joinColumns={
			@JoinColumn(name="training_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="movement_id")
			}
		)
	private List<Movement> movements;

	//bi-directional many-to-one association to TrainingType
	@ManyToOne
	@JoinColumn(name="training_type_id")
	private TrainingType trainingType;

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

	public List<Movement> getMovements() {
		return this.movements;
	}

	public void setMovements(List<Movement> movements) {
		this.movements = movements;
	}

	public TrainingType getTrainingType() {
		return this.trainingType;
	}

	public void setTrainingType(TrainingType trainingType) {
		this.trainingType = trainingType;
	}

}