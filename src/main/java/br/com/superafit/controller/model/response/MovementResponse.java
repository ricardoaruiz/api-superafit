package br.com.superafit.controller.model.response;

import java.io.Serializable;

public class MovementResponse implements Serializable {

	private static final long serialVersionUID = 8452550487339608479L;

	private String id;
	
	private String name;
	
	private String translate;
	
	private String description;
	
	private boolean active;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
		
}
