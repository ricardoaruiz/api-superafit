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
	
	public void save(CreateMovementRequest movement) {
					
		Movement movementFoundByName = movementRepository.findByName(movement.getName());
		
		if( (movementFoundByName != null && 
			 movement.getId() != null && 
			 !movementFoundByName.getId().toString().equals(movement.getId()))
			||
			(movementFoundByName != null && movement.getId() == null)
				
		) {
			throw new MovementAlreadyExistsException(MessageCodeEnum.Constants.CREATE_MOVEMENT_ALREADY_EXISTS);
		}
		
		movementRepository.save(getMovement(movement));		
	}
	
	public Movement getMovement(Long id) {
		return movementRepository.findOne(id);
	}
	
	public List<Movement> findAllActive(String name) {		
		return movementRepository.findActiveByNameLike(name);
	}
	
	public List<Movement> findAll(String name) {
		return movementRepository.findAllByNameLike(name);
	}
	
	private Movement getMovement(CreateMovementRequest movement) {
		Movement m = new Movement();
		if(movement.getId() != null && !movement.getId().isEmpty()) {
			m.setId(Long.valueOf(movement.getId()));
		}
		m.setName(movement.getName());
		m.setTranslate(movement.getTranslate());
		m.setDescription(movement.getDescription());
		m.setActive(Integer.valueOf(movement.getActive()));
		return m;
	}
	
}
