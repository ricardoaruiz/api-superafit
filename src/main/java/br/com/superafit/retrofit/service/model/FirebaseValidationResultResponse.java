package br.com.superafit.retrofit.service.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class FirebaseValidationResultResponse implements Serializable {

	private static final long serialVersionUID = 5725114575379065442L;
	
	@JsonProperty("message_id")
	private String messageId;

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	
}
