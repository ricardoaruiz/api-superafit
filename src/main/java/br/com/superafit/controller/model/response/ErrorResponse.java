package br.com.superafit.controller.model.response;

import java.io.Serializable;

public class ErrorResponse implements Serializable {

	private static final long serialVersionUID = -135853984758234403L;
	
	private final String error;
	
	public ErrorResponse(String message) {
		super();
		this.error = message;
	}

	public String getError() {
		return error;
	}
	
}
