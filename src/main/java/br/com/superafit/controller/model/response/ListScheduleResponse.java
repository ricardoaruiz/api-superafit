package br.com.superafit.controller.model.response;

import java.io.Serializable;
import java.util.List;

public class ListScheduleResponse implements Serializable {

	private static final long serialVersionUID = 5847279895149436642L;
	
	private List<ScheduleResponse> schedules;
	
	private boolean sync;

	public List<ScheduleResponse> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<ScheduleResponse> schedules) {
		this.schedules = schedules;
	}

	public boolean isSync() {
		return sync;
	}

	public void setSync(boolean sync) {
		this.sync = sync;
	}
	
}
