package br.com.superafit.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.superafit.controller.model.request.CreateDayTrainingRequest;
import br.com.superafit.controller.model.request.DayTrainingMovementsRequest;
import br.com.superafit.controller.model.response.GetDayTrainingResponse;
import br.com.superafit.enumeration.MessageCodeEnum;
import br.com.superafit.enumeration.SyncControlEnum;
import br.com.superafit.model.SyncControl;
import br.com.superafit.model.Training;
import br.com.superafit.model.TrainingMovement;
import br.com.superafit.model.TrainingMovementPK;
import br.com.superafit.model.TrainingType;
import br.com.superafit.repository.DayTrainingRepository;
import br.com.superafit.repository.MovementRepository;
import br.com.superafit.repository.TrainingMovementRepository;
import br.com.superafit.repository.TrainingTypeRepository;
import br.com.superafit.retrofit.service.model.FirebaseDataNotificationRequest;
import br.com.superafit.service.domain.ListTrainning;
import br.com.superafit.service.exception.MovementNotFoundException;
import br.com.superafit.service.exception.RegisterAlreadyExistsException;
import br.com.superafit.service.exception.TrainningAlreadyExistsException;

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
	private MovementRepository movementRepository;
	
	@Autowired
	private FirebaseService firebaseService;
	
	@Autowired
	private SyncControlService syncControlService;

	public ListTrainning getDayTraining(Date date) {
		List<Training> trainnings = dayTrainingRepository.findByDateOrderBySequence(date);
		
		ListTrainning response = new ListTrainning();
		response.setTrainnings(trainnings);
		
		SyncControl syncControl = syncControlService.getSyncControl(SyncControlEnum.TRAINNING.getValue());
		if(syncControl != null) {
			response.setSync(syncControl.isSync());
		}
		
		return response;
	}
	
	public void create(CreateDayTrainingRequest request) {	
		validateMovements(request);
		
		TrainingType type = trainingTypeRepository.findOne(Long.valueOf(request.getTraining_type()));
		Training dayTraining = dayTrainingRepository.findByDateAndTrainingType(request.getTraining_date(), type);
		
		if(dayTraining != null) {
			throw new TrainningAlreadyExistsException(MessageCodeEnum.Constants.CREATE_DAY_TRAINING_ALREADY_EXISTS);		
		}
		
		request.setSequence(type.getSequence());
		saveTraining(request);
		syncControlService.desync(SyncControlEnum.TRAINNING.getValue());
	}

	public void delete(Long id) {
		trainingMovementRepository.removeAll(id);
		dayTrainingRepository.delete(id);
		syncControlService.desync(SyncControlEnum.TRAINNING.getValue());
	}
	
	public void sendNotification() {
		FirebaseDataNotificationRequest dataNotification = new FirebaseDataNotificationRequest("Superafit", "Treino do dia disponível");		
		ListTrainning dayTraining = getDayTraining(new Date());
		
		dataNotification.putData("training", new GetDayTrainingResponse(dayTraining.getTrainnings(), dayTraining.isSync()));			
		firebaseService.send(dataNotification);
		syncControlService.sync(SyncControlEnum.TRAINNING.getValue());
	}
	
	private void validateMovements(CreateDayTrainingRequest request) {
		if(request != null && request.getMovements() != null && !request.getMovements().isEmpty()) {
			for (DayTrainingMovementsRequest movement : request.getMovements()) {
				if(movementRepository.findOne(movement.getMovement().longValue()) == null) {
					throw new MovementNotFoundException(MessageCodeEnum.Constants.CREATE_DAY_TRAINING_MOVEMENT_NOT_FOUND);
				}
			}
		}
	}

	private Training saveTraining(CreateDayTrainingRequest request) {
		try {
			Training t = dayTrainingRepository.save(getTraining(request));
			saveTrainingMovements(request, t);
			return t;
		} catch(Exception e) {
			LOG.error(e.getMessage(), e);
			if(DataIntegrityViolationException.class.isInstance(e)) {
				throw new RegisterAlreadyExistsException(MessageCodeEnum.Constants.CREATE_DAY_TRAINING_DUPLICATE_REGISTER);
			}
			throw e;
		}
	}

	private Training getTraining(CreateDayTrainingRequest request) {
		Training t = new Training();
		t.setDate(request.getTraining_date());
		t.setQtRound(request.getTraining_round());
		t.setTrainingType(trainingTypeRepository.findOne(Long.valueOf(request.getTraining_type())));
		t.setSequence(request.getSequence());
		t.setDescription(request.getDescription());
		return t;
	}
	
	private void saveTrainingMovements(CreateDayTrainingRequest request, Training t) {
		for (DayTrainingMovementsRequest m : request.getMovements()) {
			trainingMovementRepository.insert(m.getMovement(), t.getId(), m.getRepetition());
			
			TrainingMovementPK pk = new TrainingMovementPK();
			pk.setMovementId(m.getMovement());
			pk.setTrainingId(t.getId().intValue());
			
			TrainingMovement tm = new TrainingMovement();
			tm.setId(pk);
			tm.setTraining(t);
			tm.setQtRep(m.getRepetition());
			tm.setMovement(movementRepository.getOne(m.getMovement().longValue()));
			
			t.addTrainingMovement(tm);			
		}
	}
	
}
