package br.com.superafit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.superafit.controller.model.request.CreateMovementRequest;
import br.com.superafit.enumeration.MessageCodeEnum;
import br.com.superafit.model.Movement;
import br.com.superafit.repository.MovementRepository;
import br.com.superafit.service.exception.MovementAlreadyExistsException;

@Service
public class MovementService {

	@Autowired
	private MovementRepository movementRepository;
	
	public void create(CreateMovementRequest movement) {
		
		if(movementRepository.findByName(movement.getName()) != null) {
			throw new MovementAlreadyExistsException(MessageCodeEnum.Constants.CREATE_MOVEMENT_ALREADY_EXISTS);
		}
		
		movementRepository.save(getMovement(movement));		
	}
	
	public List<Movement> find(String name) {		
		return movementRepository.findByNameLike(name);
	}
	
	private Movement getMovement(CreateMovementRequest movement) {
		Movement m = new Movement();
		m.setName(movement.getName());
		m.setTranslate(movement.getTranslate());
		m.setDescription(movement.getDescription());
		return m;
	}
	
}
