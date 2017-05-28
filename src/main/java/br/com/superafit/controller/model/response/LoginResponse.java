package br.com.superafit.controller.model.response;

import java.io.Serializable;

public class LoginResponse implements Serializable {

	private static final long serialVersionUID = -7288918264983804808L;

	private int code;
	
	private String message;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
