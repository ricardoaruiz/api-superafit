package br.com.superafit.retrofit.service.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FirebaseValidationRequest implements Serializable {

	private static final long serialVersionUID = -6787286476692942462L;
	
	@JsonProperty("registration_ids")
	private String[] registrationIds;

	public String[] getRegistrationIds() {
		return registrationIds;
	}

	public void setRegistrationIds(String[] registrationIds) {
		this.registrationIds = registrationIds;
	}
	
}
