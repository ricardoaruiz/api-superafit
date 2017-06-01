package br.com.superafit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.superafit.model.Training;

public interface DayTrainingRepository extends JpaRepository<Training, Long> {

	List<Training> findAllByOrderByDateDesc();
	
}
