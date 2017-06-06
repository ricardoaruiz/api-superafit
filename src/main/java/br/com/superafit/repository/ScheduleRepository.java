package br.com.superafit.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.superafit.model.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>{

	List<Schedule> findAllByOrderByWeekDayAscScheduleStartAsc();
	
	Schedule findByWeekDayAndScheduleStartAndScheduleEnd(int weekDay, Date scheduleStart, Date scheduleEnd);
	
	@Query("SELECT s FROM Schedule s WHERE s.weekDay = :weekDay AND ((:start > s.scheduleStart AND :start < s.scheduleEnd) OR (:end > s.scheduleStart AND :end < s.scheduleEnd))")
	Schedule findConflictSchedule(@Param("weekDay") int weekDay, @Param("start") Date start, @Param("end") Date end);
	
}
