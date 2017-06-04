package br.com.superafit.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.superafit.controller.model.request.CreateDayTrainingRequest;
import br.com.superafit.controller.model.request.DayTrainingMovementsRequest;
import br.com.superafit.controller.model.response.DayTrainingResponse;
import br.com.superafit.controller.model.response.MovementResponse;
import br.com.superafit.model.Training;
import br.com.superafit.model.TrainingMovement;
import br.com.superafit.repository.DayTrainingRepository;
import br.com.superafit.repository.TrainingMovementRepository;
import br.com.superafit.repository.TrainingTypeRepository;

@Service
public class DayTrainingService {

	@Autowired
	private DayTrainingRepository dayTrainingRepository;
	
	@Autowired
	private TrainingTypeRepository trainingTypeRepository;
		
	@Autowired
	private TrainingMovementRepository trainingMovementRepository;
	
	private SimpleDateFormat diaMesAno = new SimpleDateFormat("dd/MM/yyyy");

	public void create(CreateDayTrainingRequest request) {
			
		Training t = new Training();
		t.setDate(request.getTraining_date());
		t.setQtRound(request.getTraining_round());
		t.setTrainingType(trainingTypeRepository.findOne(Long.valueOf(request.getTraining_type())));
		dayTrainingRepository.save(t);

		saveTrainingMovements(request, t);

	}
	
	private void saveTrainingMovements(CreateDayTrainingRequest request, Training t) {
		for (DayTrainingMovementsRequest m : request.getMovements()) {
			trainingMovementRepository.insert(m.getMovement(), t.getId(), m.getRepetition());
		}
	}

	public DayTrainingResponse getDayTraining(Date date) {
			
		Training training = dayTrainingRepository.findByDate(date);	
		
		if(training != null) {
			DayTrainingResponse toReturn = new DayTrainingResponse();
			toReturn.setDate(diaMesAno.format(training.getDate()));
			toReturn.setRound(training.getQtRound());
			toReturn.setType(training.getTrainingType().getName());			
			toReturn.setMovements(getMovements(training.getTrainingMovements()));
			return toReturn;
		}
		
		return null;
		
	}

	private List<MovementResponse> getMovements(List<TrainingMovement> trainingMovement) {
		List<MovementResponse> toReturn = new ArrayList<MovementResponse>();
		
		for (TrainingMovement movement : trainingMovement) {
			MovementResponse m = new MovementResponse();
			m.setName(movement.getMovement().getName());
			m.setTranslate(movement.getMovement().getTranslate());
			m.setDescription(movement.getMovement().getDescription());
			m.setQtRep(movement.getQtRep());
			toReturn.add(m);
		}
		
		return toReturn;
	}
	
}
