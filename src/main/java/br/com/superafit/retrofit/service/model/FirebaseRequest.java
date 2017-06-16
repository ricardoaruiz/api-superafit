package br.com.superafit.retrofit.service.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class FirebaseRequest implements Serializable {
	
	private static final long serialVersionUID = -6374366194079302400L;

	private String to;
	
	private String priority;
	
	@JsonProperty("time_to_live")
	private Long timeToLive;
	
	@JsonProperty("delay_while_idle")
	private boolean delayWhileIdle = true;
	
	@JsonProperty("collapse_key")
	private String collapseKey;
		
	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getPriority() {
		if(priority == null) {
			return "high";
		}
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	public Long getTimeToLive() {
		return timeToLive == null ? 86400 : timeToLive;
	}

	public void setTimeToLive(Long timeToLive) {
		this.timeToLive = timeToLive;
	}
	
	public boolean isDelayWhileIdle() {
		return delayWhileIdle;
	}

	public void setDelayWhileIdle(boolean delayWhileIdle) {
		this.delayWhileIdle = delayWhileIdle;
	}
	
	public String getCollapseKey() {
		return collapseKey == null ? "Updates Available" : collapseKey;
	}

	public void setCollapseKey(String collapseKey) {
		this.collapseKey = collapseKey;
	}
		
}
