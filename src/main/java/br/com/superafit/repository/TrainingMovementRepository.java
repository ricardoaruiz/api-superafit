package br.com.superafit.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.superafit.model.TrainingMovement;
import br.com.superafit.model.TrainingMovementPK;

public interface TrainingMovementRepository extends JpaRepository<TrainingMovement, TrainingMovementPK>{

	@Modifying
	@Query(value="INSERT INTO training_movement (movement_id, training_id, qt_rep) VALUES (:movementId, :trainingId, :qtRepo)", nativeQuery=true)
	@Transactional
	void insert(@Param("movementId") int movementId, 
			    @Param("trainingId") long trainingId, 
			    @Param("qtRepo") int qtRepo);
	
}
