package br.com.superafit.controller.model.response;

import java.io.Serializable;

public class MovementResponse implements Serializable {

	private static final long serialVersionUID = 7717090283272543828L;

	private String name;
	
	private String translate;
	
	private String description;
	
	private int qtRep;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTranslate() {
		return translate;
	}

	public void setTranslate(String translate) {
		this.translate = translate;
	}

	public int getQtRep() {
		return qtRep;
	}

	public void setQtRep(int qtRep) {
		this.qtRep = qtRep;
	}

}
