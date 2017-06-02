package br.com.superafit.controller.model.response;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ErrorsResponse implements Serializable {

	private static final long serialVersionUID = 4470978278346644944L;
	
	private Set<ErrorResponse> errors;
	
	public Set<ErrorResponse> getErrors() {
		return errors;
	}

	public void addErrors(ErrorResponse error) {
		if(this.errors == null) {
			this.errors = new HashSet<ErrorResponse>();
		}
		this.errors.add(error);
	}
	
}
