package br.com.superafit.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the training_type database table.
 * 
 */
@Entity
@Table(name="training_type")
public class TrainingType implements Serializable {

	private static final long serialVersionUID = -6428665467552975508L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String name;

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

}