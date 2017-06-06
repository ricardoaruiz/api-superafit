package br.com.superafit.controller.model.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DayScheduleResponse implements Serializable {

	private static final long serialVersionUID = 7674602601783029403L;

	@JsonProperty("schedule_start")
	private String scheduleStart;
	
	@JsonProperty("schedule_end")
	private String scheduleEnd;

	public String getScheduleStart() {
		return scheduleStart;
	}

	public void setScheduleStart(String scheduleStart) {
		this.scheduleStart = scheduleStart;
	}

	public String getScheduleEnd() {
		return scheduleEnd;
	}

	public void setScheduleEnd(String scheduleEnd) {
		this.scheduleEnd = scheduleEnd;
	}
	
}
