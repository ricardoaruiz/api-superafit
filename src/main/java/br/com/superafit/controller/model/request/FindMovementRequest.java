package br.com.superafit.controller.model.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class FindMovementRequest implements Serializable {

	private static final long serialVersionUID = 4939590713284308849L;
	
	@ApiModelProperty(example="Double Under")
	private String name;

	public String getName() {
		if(name != null && !name.isEmpty()) {
			return "%" + name + "%";
		}
		return null;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
