package br.com.superafit.controller.model.response;

import java.io.Serializable;

public class CreateUserResponse implements Serializable{

	private static final long serialVersionUID = -2112145088546880975L;
	
	private final String userId;
	
	public CreateUserResponse(String userId) {
		super();
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}
	
}
