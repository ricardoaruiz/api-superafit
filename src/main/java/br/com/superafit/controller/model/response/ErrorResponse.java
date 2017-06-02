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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((error == null) ? 0 : error.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErrorResponse other = (ErrorResponse) obj;
		if (error == null) {
			if (other.error != null)
				return false;
		} else if (!error.equals(other.error))
			return false;
		return true;
	}
	
}
