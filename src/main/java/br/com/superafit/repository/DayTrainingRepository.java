package br.com.superafit.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.superafit.model.Training;

public interface DayTrainingRepository extends JpaRepository<Training, Long> {

	Training findByDate(Date date);
	
	@Modifying
	@Query(value="DELETE FROM training WHERE id = :id", nativeQuery=true)
	@Transactional(propagation=Propagation.REQUIRED)
	void delete(@Param("id") Long id);
	
}
