package br.com.superafit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.superafit.model.TrainingType;
import br.com.superafit.repository.TrainingTypeRepository;

@Service
public class TrainingTypeService {

	@Autowired
	private TrainingTypeRepository repository;
	
	public List<TrainingType> findAll() {
		return repository.findAll();
	}
	
}
