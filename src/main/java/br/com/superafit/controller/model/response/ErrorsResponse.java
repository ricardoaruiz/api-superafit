package br.com.superafit.controller.model.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ErrorsResponse implements Serializable {

	private static final long serialVersionUID = 4470978278346644944L;
	
	private List<ErrorResponse> errors;
	
	public List<ErrorResponse> getErrors() {
		return errors;
	}

	public void addErrors(ErrorResponse error) {
		if(this.errors == null) {
			this.errors = new ArrayList<ErrorResponse>();
		}
		this.errors.add(error);
	}
	
}
