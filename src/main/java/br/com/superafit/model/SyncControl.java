package br.com.superafit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="sync_control")
public class SyncControl {
	
	@Id
	private String entity;
	
	private boolean sync;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="sync_date")
	private Date syncDate;

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public boolean isSync() {
		return sync;
	}

	public void setSync(boolean sync) {
		this.sync = sync;
	}

	public Date getSyncDate() {
		return syncDate;
	}

	public void setSyncDate(Date syncDate) {
		this.syncDate = syncDate;
	}
	
	public void sync() {
		this.sync = true;
	}
	
	public void desync() {
		this.sync = false;
	}
	
}
