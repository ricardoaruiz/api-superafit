package br.com.superafit.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.superafit.model.SyncControl;
import br.com.superafit.repository.SyncControlRepository;

@Service
public class SyncControlService {

	@Autowired
	private SyncControlRepository repository;
	
	public SyncControl getSyncControl(String suncEntity) {
		return repository.findOne(suncEntity);
	}
	
	public void sync(String syncEntity) {		
		SyncControl objSyncEntity = getSyncControl(syncEntity);
		if(objSyncEntity == null) {
			objSyncEntity = getSyncControlRequest(syncEntity, true);			
		} else {
			objSyncEntity.sync();
		}
		repository.save(objSyncEntity);		
	}
	
	public void desync(String syncEntity) {
		SyncControl objSyncEntity = getSyncControl(syncEntity);
		if(objSyncEntity == null) {
			objSyncEntity = getSyncControlRequest(syncEntity, false);			
		} else {
			objSyncEntity.desync();
		}
		repository.save(objSyncEntity);		
	}
	
	private SyncControl getSyncControlRequest(String syncEntity, boolean sync) {
		SyncControl objSyncEntity = new SyncControl();
		objSyncEntity.setEntity(syncEntity);
		objSyncEntity.setSyncDate(new Date());
		objSyncEntity.setSync(sync);
		return objSyncEntity;
	}
	
}
