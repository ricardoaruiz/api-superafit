package br.com.superafit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.superafit.model.Movement;

public interface MovementRepository extends JpaRepository<Movement, Long>{

	Movement findByName(String name);
	
	@Query("SELECT m FROM Movement m WHERE m.active = 1 AND (:name IS NULL OR name LIKE :name) ORDER BY m.name")
	List<Movement> findActiveByNameLike(@Param("name") String name);

	@Query("SELECT m FROM Movement m WHERE :name IS NULL OR name LIKE :name ORDER BY m.name")
	List<Movement> findAllByNameLike(@Param("name") String name);
	
}
