package br.com.superafit.controller.model.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.superafit.service.domain.IDevice;

public class CreateDeviceRequest implements IDevice, Serializable {

	private static final long serialVersionUID = -8671798117904686892L;
	
	@JsonProperty("token")
	private String token;

	@Override
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
