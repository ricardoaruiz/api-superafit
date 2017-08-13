package br.com.superafit.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.superafit.model.Training;
import br.com.superafit.model.TrainingType;

public interface DayTrainingRepository extends JpaRepository<Training, Long> {

	List<Training> findByDateOrderBySequence(Date date);
	
	Training findByDateAndTrainingType(Date date, TrainingType type);
	
	List<Training> findByDateLessThan(Date date);
	
	@Modifying
	@Query(value="DELETE FROM training WHERE id = :id", nativeQuery=true)
	@Transactional(propagation=Propagation.REQUIRED)
	void delete(@Param("id") Long id);
	
}
