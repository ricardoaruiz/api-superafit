package br.com.superafit.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the movement database table.
 * 
 */
@Entity
@Table(name="movement")
public class Movement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String description;

	private String name;

	private String translate;

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

}