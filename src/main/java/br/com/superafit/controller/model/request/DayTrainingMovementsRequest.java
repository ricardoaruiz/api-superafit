package br.com.superafit.controller.model.request;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import br.com.superafit.enumeration.MessageCodeEnum;
import io.swagger.annotations.ApiModelProperty;

public class DayTrainingMovementsRequest implements Serializable {

	private static final long serialVersionUID = -425189038663878427L;

	@ApiModelProperty(example="1", required=true)
	@NotNull(message=MessageCodeEnum.Constants.CREATE_DAY_TRAINING_REQUIRED_MOVEMENT)
	private Integer movement;
	
	@ApiModelProperty(example="20", required=true)
	@NotNull(message=MessageCodeEnum.Constants.CREATE_DAY_TRAINING_REQUIRED_MOVEMENT_REPETITION)
	@Min(value=1, message=MessageCodeEnum.Constants.CREATE_DAY_TRAINING_REQUIRED_MOVEMENT_MIN_REPETITION)
	private Integer repetition;

	public Integer getMovement() {
		return movement;
	}

	public void setMovement(Integer movement) {
		this.movement = movement;
	}

	public Integer getRepetition() {
		return repetition;
	}

	public void setRepetition(Integer repetition) {
		this.repetition = repetition;
	}
	
}
