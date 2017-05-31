package br.com.superafit.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.superafit.controller.model.response.DayScheduleResponse;
import br.com.superafit.controller.model.response.ListScheduleResponse;
import br.com.superafit.controller.model.response.ScheduleResponse;
import br.com.superafit.enumeration.WeekDayEnum;
import br.com.superafit.model.Schedule;
import br.com.superafit.repository.ScheduleRepository;

@Service
public class ScheduleService {

	@Autowired
	private ScheduleRepository scheduleRepository;
	
	public ListScheduleResponse list() {
		ListScheduleResponse response = new ListScheduleResponse();
				
		List<Schedule> schedules = scheduleRepository.findAllByOrderByWeekDayAscShceduleStartAsc();
		if(schedules != null && !schedules.isEmpty()) {
			response.setSchedules(getSchedules(schedules));
		}
		
		return response;
	}

	private List<ScheduleResponse> getSchedules(List<Schedule> schedules) {
		List<ScheduleResponse> listSchedules = new ArrayList<ScheduleResponse>();
		
		LinkedHashMap<String, ScheduleResponse> temp = new LinkedHashMap<String, ScheduleResponse>();
		
		String currentWeekDay = "";
		String nextWeekDay = "";
		
		ScheduleResponse scheduleResponse = null;
		
		for(Schedule s : schedules) {
			currentWeekDay = getWeekDay(s.getWeekDay());
			
			if(!currentWeekDay.equals(nextWeekDay)) {
				scheduleResponse = new ScheduleResponse();
				scheduleResponse.setWeekDay(currentWeekDay);
				temp.put(currentWeekDay, scheduleResponse);
			} else {
				scheduleResponse = temp.get(currentWeekDay);
			}
			
			DayScheduleResponse ds = new DayScheduleResponse();
			ds.setScheduleStart(getSchedule(s.getShceduleStart()));
			ds.setShceduleEnd(getSchedule(s.getScheduleEnd()));			
			scheduleResponse.addDaySchedule(ds);			
			
			nextWeekDay = getWeekDay(s.getWeekDay());
		}
		
		for(String key : temp.keySet()) {
			listSchedules.add(temp.get(key));
		}
		
		return listSchedules;
	}

	private int getHour(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.HOUR_OF_DAY);
	}
	
	private int getMinutes(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MINUTE);		
	}
	
	private String getSchedule(Date date) {
		int hour = getHour(date);
		int minutes = getMinutes(date);
			
		String strHour = hour < 10 ? "0" + hour : String.valueOf(hour);
		String strMinute = minutes < 10 ? "0" + minutes : String.valueOf(minutes);
		
		return strHour + ":" + strMinute;
	}

	private String getWeekDay(final int weekDay) {		
		return WeekDayEnum.fromCode(weekDay).getDesc();
	}
	
}
