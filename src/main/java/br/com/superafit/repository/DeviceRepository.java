package br.com.superafit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.superafit.model.Device;
import br.com.superafit.model.DevicePK;


public interface DeviceRepository extends JpaRepository<Device, DevicePK>{

	Device findByToken(String token);
	
}
