package br.com.superafit.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.superafit.controller.model.response.DayScheduleResponse;
import br.com.superafit.controller.model.response.ListScheduleResponse;
import br.com.superafit.controller.model.response.ScheduleResponse;
import br.com.superafit.enumeration.MessageCodeEnum;
import br.com.superafit.enumeration.SyncControlEnum;
import br.com.superafit.enumeration.WeekDayEnum;
import br.com.superafit.model.Schedule;
import br.com.superafit.model.SyncControl;
import br.com.superafit.repository.ScheduleRepository;
import br.com.superafit.retrofit.service.model.FirebaseDataNotificationRequest;
import br.com.superafit.service.domain.ISchedule;
import br.com.superafit.service.exception.InvalidScheduleException;
import br.com.superafit.service.exception.ScheduleAlreadyExists;

@Service
public class ScheduleService {
	
	private final Logger LOG = LoggerFactory.getLogger(ScheduleService.class);
	
	private static final int ONE_SECOND_IN_MILLISECOND = 1000;

	private static final int HOUR_IN_SECONDS = 3600;
	
	@Autowired
	private ScheduleRepository scheduleRepository;
		
	@Autowired
	private FirebaseService firebaseService;
	
	@Autowired
	private SyncControlService syncControlService;
	
	public void insert(ISchedule schedule) {
		
		LOG.info("Inserindo horário");
		
		Schedule s = getSchedule(schedule);
		
		validateScheduleRange(schedule);		
		validateScheduleDuration(schedule);
		verifyAlreadyExist(s);
		
		scheduleRepository.save(s);
		syncControlService.desync(SyncControlEnum.SCHEDULE.getValue());
		
	}

	public ListScheduleResponse list() {
		ListScheduleResponse response = new ListScheduleResponse();
				
		List<Schedule> schedules = scheduleRepository.findAllByOrderByWeekDayAscScheduleStartAsc();
		if(schedules != null && !schedules.isEmpty()) {
			response = new ListScheduleResponse();
			response.setSchedules(getSchedules(schedules));			
		}
		SyncControl syncControl = syncControlService.getSyncControl(SyncControlEnum.SCHEDULE.getValue());
		response.setSync(syncControl == null ? true : syncControl.isSync());
		
		return response;
	}
	
	public void remove(ISchedule request) {
		Schedule schedule = scheduleRepository.findByWeekDayAndScheduleStart(request.getWeekDay(), request.getScheduleStart());
		if(schedule != null) {
			scheduleRepository.delete(schedule);
			syncControlService.desync(SyncControlEnum.SCHEDULE.getValue());
		}
	}
	
	public void sendScheduleNotification() {
		FirebaseDataNotificationRequest request = new FirebaseDataNotificationRequest("Superafit", "Os horários da academia foram atualizados.");
		request.putData("schedule", list());
		firebaseService.send(request);
		syncControlService.sync(SyncControlEnum.SCHEDULE.getValue());
	}
	
	private void validateScheduleDuration(ISchedule schedule) {
		Long seconds = (schedule.getScheduleEnd().getTime() - schedule.getScheduleStart().getTime()) / ONE_SECOND_IN_MILLISECOND;
		if(seconds != HOUR_IN_SECONDS) {
			LOG.info("Inserindo horário - duração inválida.");
			throw new InvalidScheduleException(MessageCodeEnum.Constants.CREATE_SCHEDULE_INVALID_SCHEDULE);
		}
	}

	private void validateScheduleRange(ISchedule schedule) {
		if(schedule.getScheduleStart().equals(schedule.getScheduleEnd()) || schedule.getScheduleStart().after(schedule.getScheduleEnd())) {
			LOG.info("Inserindo horário - horário inicício menor ou igual que horário fim");
			throw new InvalidScheduleException(MessageCodeEnum.Constants.CREATE_SCHEDULE_END_MUST_GREATER_THAN_START);			
		}
	}

	private void verifyAlreadyExist(Schedule s) {
		Schedule scheduleFound = scheduleRepository.findByWeekDayAndScheduleStartAndScheduleEnd(s.getWeekDay(), s.getScheduleStart(), s.getScheduleEnd());
		if(scheduleFound != null) {
			LOG.info("Inserindo horário - horário já existente.");
			throw new ScheduleAlreadyExists(MessageCodeEnum.Constants.CREATE_SCHEDULE_ALREADY_EXISTS);
		}
		
		List<Schedule> scheduleFound1 = scheduleRepository.findConflictSchedule(s.getWeekDay(), s.getScheduleStart(), s.getScheduleEnd());		
		if(scheduleFound1 != null && !scheduleFound1.isEmpty()) {
			LOG.info("Inserindo horário - horário já existente.");
			throw new ScheduleAlreadyExists(MessageCodeEnum.Constants.CREATE_SCHEDULE_ALREADY_EXISTS);
		}
	}

	private Schedule getSchedule(ISchedule schedule) {
		Schedule s = new Schedule();
		s.setWeekDay(schedule.getWeekDay());
		s.setScheduleStart(schedule.getScheduleStart());
		s.setScheduleEnd(schedule.getScheduleEnd());
		return s;
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
			ds.setScheduleStart(getSchedule(s.getScheduleStart()));
			ds.setScheduleEnd(getSchedule(s.getScheduleEnd()));			
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
