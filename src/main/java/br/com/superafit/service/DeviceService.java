package br.com.superafit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.superafit.model.Device;
import br.com.superafit.repository.DeviceRepository;
import br.com.superafit.service.domain.IDevice;

@Service
public class DeviceService {

	@Autowired
	private DeviceRepository deviceRepository;
		
	public void save(IDevice request) {		
		insertDevice(request);
	}

	public List<Device> listAll() {
		return deviceRepository.findAll();
	}
	
	public void remove(String deviceToken) {	
		Device device = deviceRepository.findByToken(deviceToken);
		if(device != null) {
			deviceRepository.delete(device);
		}
	}
	
	private void insertDevice(IDevice request) {			
		Device device = new Device();
		device.setToken(request.getToken());
		deviceRepository.save(device);
	}
	
}
