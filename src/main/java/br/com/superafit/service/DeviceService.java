package br.com.superafit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.superafit.model.Device;
import br.com.superafit.model.DevicePK;
import br.com.superafit.model.User;
import br.com.superafit.repository.DeviceRepository;
import br.com.superafit.repository.UserRepository;
import br.com.superafit.service.domain.IDevice;

@Service
public class DeviceService {

	@Autowired
	private DeviceRepository deviceRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public void save(IDevice request) {		
		Device deviceFound = deviceRepository.findByUserId(request.getUserId());
		if(deviceFound != null) {
			if(!deviceFound.getId().getToken().equals(request.getToken())) {
				deviceRepository.delete(deviceFound);
				insertDevice(request);
			}
		} else {		
			insertDevice(request);
		}
	}

	private void insertDevice(IDevice request) {
		User user = userRepository.findOne(request.getUserId());
		
		Device device = new Device();
		device.setUser(user);
		
		DevicePK pk = new DevicePK();
		pk.setToken(request.getToken());
		pk.setUserId(request.getUserId());		
		device.setId(pk);
		
		deviceRepository.save(device);
	}
}
