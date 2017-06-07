package br.com.superafit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.superafit.model.Device;
import br.com.superafit.model.DevicePK;

public interface DeviceRepository extends JpaRepository<Device, DevicePK>{

	Device findByUserId(String userId);
	
}
