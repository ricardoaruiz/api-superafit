package br.com.superafit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.superafit.model.Movement;

public interface MovementRepository extends JpaRepository<Movement, Long>{

}
