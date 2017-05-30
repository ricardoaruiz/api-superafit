package br.com.superafit.controller.model.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScheduleResponse implements Serializable {

	private static final long serialVersionUID = 4827741798526088834L;

	@JsonProperty("week_day")
	private String weekDay;
	
	@JsonProperty("day_schedules")
	private List<DayScheduleResponse> daySchedules;

	public String getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
	}

	public List<DayScheduleResponse> getDaySchedules() {
		return daySchedules;
	}

	public void setDaySchedules(List<DayScheduleResponse> daySchedules) {
		this.daySchedules = daySchedules;
	}
	
	public void addDaySchedule(DayScheduleResponse daySchedule) {
		if(this.daySchedules == null) {
			this.daySchedules = new ArrayList();
		}
		this.daySchedules.add(daySchedule);
	}
	
}
