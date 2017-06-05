package br.com.superafit.controller.model.request;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.superafit.enumeration.MessageCodeEnum;

public class GetDayTrainingRequest implements Serializable {

	private static final long serialVersionUID = -3228935342776052742L;
	
	@NotNull(message=MessageCodeEnum.Constants.CREATE_DAY_TRAINING_REQUIRED_DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
