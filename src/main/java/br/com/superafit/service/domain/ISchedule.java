package br.com.superafit.service.domain;

import java.util.Date;

public interface ISchedule {

	Integer getWeekDay();
	
	Date getScheduleStart();
	
	Date getScheduleEnd();
	
}
