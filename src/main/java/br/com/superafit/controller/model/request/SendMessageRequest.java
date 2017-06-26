package br.com.superafit.controller.model.request;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.superafit.enumeration.MessageCodeEnum;
import br.com.superafit.service.domain.IMessage;

public class SendMessageRequest implements IMessage, Serializable {

	private static final long serialVersionUID = -1603946111297004346L;
	
	@NotEmpty(message=MessageCodeEnum.Constants.SEND_MESSAGE_REQUIRED_TEXT)
	private String text;
	
	@Override
	public Long getId() {
		return null;
	}

	@Override
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
