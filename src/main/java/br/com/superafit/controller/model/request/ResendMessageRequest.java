package br.com.superafit.controller.model.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import br.com.superafit.enumeration.MessageCodeEnum;
import br.com.superafit.service.domain.IMessage;

public class ResendMessageRequest implements IMessage, Serializable {

	private static final long serialVersionUID = 4652875244103854181L;
	
	@NotNull(message=MessageCodeEnum.Constants.SEND_MESSAGE_REQUIRED_ID)
	private Long id;
	
	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getText() {
		return null;
	}

}
