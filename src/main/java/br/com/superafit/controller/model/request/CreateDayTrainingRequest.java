package br.com.superafit.controller.model.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.superafit.enumeration.MessageCodeEnum;
import io.swagger.annotations.ApiModelProperty;

public class CreateDayTrainingRequest implements Serializable {
	
	private static final long serialVersionUID = 3286240843984490189L;

	@ApiModelProperty(example="01/01/2017", required=true)
	@NotNull(message=MessageCodeEnum.Constants.CREATE_DAY_TRAINING_REQUIRED_DATE)
	@JsonFormat(pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	private Date training_date;
	
	@ApiModelProperty(example="1", required=true)
	@NotNull(message=MessageCodeEnum.Constants.CREATE_DAY_TRAINING_REQUIRED_TYPE)
	private Integer training_type;
	
	@ApiModelProperty(example="2", required=true)
	@NotNull(message=MessageCodeEnum.Constants.CREATE_DAY_TRAINING_REQUIRED_ROUNDS)
	@Min(value=1, message=MessageCodeEnum.Constants.CREATE_DAY_TRAINING_MIN_ROUNDS)
	private Integer training_round;
	
	@Valid
	@ApiModelProperty(required=true)
	@NotEmpty(message=MessageCodeEnum.Constants.CREATE_DAY_TRAINING_REQUIRED_MOVEMENTS)
	private List<DayTrainingMovementsRequest> movements;

	public Date getTraining_date() {
		return training_date;
	}

	public void setTraining_date(Date training_date) {
		this.training_date = training_date;
	}

	public Integer getTraining_type() {
		return training_type;
	}

	public void setTraining_type(Integer training_type) {
		this.training_type = training_type;
	}

	public Integer getTraining_round() {
		return training_round;
	}

	public void setTraining_round(Integer training_round) {
		this.training_round = training_round;
	}

	public List<DayTrainingMovementsRequest> getMovements() {
		return movements;
	}

	public void setMovements(List<DayTrainingMovementsRequest> movements) {
		this.movements = movements;
	}
	
}
