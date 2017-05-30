package br.com.superafit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.superafit.model.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>{

	List<Schedule> findAllByOrderByWeekDayAscShceduleStartAsc();
	
}
