package br.com.superafit.controller.model.request;

import java.io.Serializable;

import br.com.superafit.model.Movement;

public class MovementResponse implements Serializable{

	private static final long serialVersionUID = -4486244196889153032L;
	
	private Movement movement;
	
	public MovementResponse(Movement movement) {
		this.movement = movement;
	}

	public Long getId() {
		return hasMovement() ? this.movement.getId() : null;
	}

	public String getName() {
		return hasMovement() ? this.movement.getName() : null;
	}

	public String getTranslate() {
		return hasMovement() ? this.movement.getTranslate() : null;
	}

	public String getDescription() {
		return hasMovement() ? this.movement.getDescription() : null;
	}

	public boolean isActive() {
		return hasMovement() ? this.movement.isActive() : false;
	}

	private boolean hasMovement() {
		return this.movement != null;
	}
}
