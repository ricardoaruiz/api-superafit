package br.com.superafit.controller.model.request;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.superafit.enumeration.MessageCodeEnum;
import br.com.superafit.service.domain.ISchedule;

public class CreateScheduleRequest implements ISchedule, Serializable {

	private static final long serialVersionUID = 2621596890569488121L;

	@JsonProperty("week_day")
	@NotNull(message=MessageCodeEnum.Constants.CREATE_SCHEDULE_REQUIRED_WEEKDAY)
	private Integer weekDay;
	
	@JsonProperty("schedule_start")
	@JsonFormat(pattern = "HH:mm", locale = "pt-BR", timezone = "Brazil/East")
	@NotNull(message=MessageCodeEnum.Constants.CREATE_SCHEDULE_REQUIRED_START)
	private Date scheduleStart;
	
	@JsonProperty("schedule_end")
	@JsonFormat(pattern = "HH:mm", locale = "pt-BR", timezone = "Brazil/East")
	@NotNull(message=MessageCodeEnum.Constants.CREATE_SCHEDULE_REQUIRED_END)
	private Date scheduleEnd;
	
	@Override
	public Integer getWeekDay() {
		return weekDay;
	}

	@Override
	public Date getScheduleStart() {
		return scheduleStart;
	}

	@Override
	public Date getScheduleEnd() {
		return scheduleEnd;
	}

}
