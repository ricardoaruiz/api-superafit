package br.com.superafit.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.superafit.controller.model.request.CreateDayTrainingRequest;
import br.com.superafit.controller.model.request.DayTrainingMovementsRequest;
import br.com.superafit.model.Training;
import br.com.superafit.model.TrainingMovement;
import br.com.superafit.repository.DayTrainingRepository;
import br.com.superafit.repository.TrainingMovementRepository;
import br.com.superafit.repository.TrainingTypeRepository;
import br.com.superafit.retrofit.service.model.FirebaseNotificationRequest;

@Service
public class DayTrainingService {

	private final Logger LOG = LoggerFactory.getLogger(DayTrainingService.class);
	
	@Autowired
	private DayTrainingRepository dayTrainingRepository;
	
	@Autowired
	private TrainingTypeRepository trainingTypeRepository;
		
	@Autowired
	private TrainingMovementRepository trainingMovementRepository;
	
	@Autowired
	private FirebaseService firebaseService;
	
	public void create(CreateDayTrainingRequest request) {		
		Training dayTraining = getDayTraining(request.getTraining_date());
		
		if(dayTraining != null) {
			for (TrainingMovement trainingMovement : dayTraining.getTrainingMovements()) {
				trainingMovementRepository.delete(trainingMovement);				
			}
			dayTrainingRepository.delete(dayTraining);		
		}
		saveTraining(request);
	}

	private void saveTraining(CreateDayTrainingRequest request) {
		try {
			Training t = getTraining(request);			
			dayTrainingRepository.save(t);
			saveTrainingMovements(request, t);				
			
			firebaseService.send(new FirebaseNotificationRequest("Superafit", "Treino do dia disponível"));			
		} catch(Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}

	private Training getTraining(CreateDayTrainingRequest request) {
		Training t = new Training();
		t.setDate(request.getTraining_date());
		t.setQtRound(request.getTraining_round());
		t.setTrainingType(trainingTypeRepository.findOne(Long.valueOf(request.getTraining_type())));
		return t;
	}
	
	private void saveTrainingMovements(CreateDayTrainingRequest request, Training t) {
		for (DayTrainingMovementsRequest m : request.getMovements()) {
			trainingMovementRepository.insert(m.getMovement(), t.getId(), m.getRepetition());
		}
	}

	public Training getDayTraining(Date date) {
		return dayTrainingRepository.findByDate(date);
	}
	
}
