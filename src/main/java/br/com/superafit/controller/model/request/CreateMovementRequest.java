package br.com.superafit.controller.model.request;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.superafit.enumeration.MessageCodeEnum;
import io.swagger.annotations.ApiModelProperty;

public class CreateMovementRequest implements Serializable {

	private static final long serialVersionUID = -8908310774197694948L;

	private String id;
	
	@ApiModelProperty(example="Single Under", required=true)
	@NotEmpty(message=MessageCodeEnum.Constants.CREATE_MOVEMENT_REQUIRED_NAME)
	private String name;
	
	@ApiModelProperty(example="Corda simples", required=true)
	//@NotEmpty(message=MessageCodeEnum.Constants.CREATE_MOVEMENT_REQUIRED_TRANSLATE)
	private String translate;
	
	@ApiModelProperty(example="Descrição para corda simples", required=true)
	private String description;
	
	private String active;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTranslate() {
		return translate;
	}

	public void setTranslate(String translate) {
		this.translate = translate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
}
