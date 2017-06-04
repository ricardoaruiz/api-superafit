package br.com.superafit.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.superafit.model.Training;

public interface DayTrainingRepository extends JpaRepository<Training, Long> {

	Training findByDate(Date date);
	
}
