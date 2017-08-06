package br.com.superafit.controller.model.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.superafit.controller.model.response.MovementResponse;
import br.com.superafit.model.Movement;

public class FindMovementResponse implements Serializable {
		
	private static final long serialVersionUID = -330391695903889863L;
	
	private List<MovementResponse> movements;
	
	public FindMovementResponse(List<Movement> movs) {
		this.movements = new ArrayList<MovementResponse>();
		for (Movement mov : movs) {
			MovementResponse m = new MovementResponse();
			m.setId(mov.getId().toString());
			m.setName(mov.getName());
			m.setTranslate(mov.getTranslate());
			m.setDescription(mov.getDescription());
			m.setActive(mov.isActive());
			this.movements.add(m);
		}
	}	

	public List<MovementResponse> getMovements() {
		return movements;
	}
	
	public boolean hasMovements() {
		return movements != null && !movements.isEmpty();
	}
	
}
