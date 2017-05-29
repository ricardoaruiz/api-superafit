package br.com.superafit.controller.model.response;

import java.io.Serializable;

public class LoginResponse implements Serializable {

	private static final long serialVersionUID = -7288918264983804808L;

	private String userId;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String code) {
		this.userId = code;
	}

}
