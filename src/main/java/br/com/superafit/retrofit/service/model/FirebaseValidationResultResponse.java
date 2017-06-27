package br.com.superafit.retrofit.service.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class FirebaseValidationResultResponse implements Serializable {

	private static final long serialVersionUID = 3600571790037650153L;

	@JsonProperty("message_id")
	private String messageId;
	
	private String error;

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
}
