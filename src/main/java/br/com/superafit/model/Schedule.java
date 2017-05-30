package br.com.superafit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="schedule")
public class Schedule {

	@Id
	private Long id;
	
	@Column(name="week_day")
	private int weekDay;
	
	@Column(name="schedule_start")
	private Date shceduleStart;
	
	@Column(name="schedule_end")
	private Date scheduleEnd;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(int weekDay) {
		this.weekDay = weekDay;
	}

	public Date getShceduleStart() {
		return shceduleStart;
	}

	public void setShceduleStart(Date shceduleStart) {
		this.shceduleStart = shceduleStart;
	}

	public Date getScheduleEnd() {
		return scheduleEnd;
	}

	public void setScheduleEnd(Date scheduleEnd) {
		this.scheduleEnd = scheduleEnd;
	}
	
}
