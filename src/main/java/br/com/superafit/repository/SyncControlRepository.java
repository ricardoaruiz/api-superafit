package br.com.superafit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.superafit.model.SyncControl;

public interface SyncControlRepository extends JpaRepository<SyncControl, String>{

}
