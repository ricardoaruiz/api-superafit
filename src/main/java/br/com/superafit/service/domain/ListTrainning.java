package br.com.superafit.service.domain;

import java.io.Serializable;
import java.util.List;

import br.com.superafit.model.Training;

public class ListTrainning implements Serializable {

	private static final long serialVersionUID = -208768432755862702L;

	private List<Training> trainnings;
	
	private boolean sync;

	public List<Training> getTrainnings() {
		return trainnings;
	}

	public void setTrainnings(List<Training> trainnings) {
		this.trainnings = trainnings;
	}

	public boolean isSync() {
		return sync;
	}

	public void setSync(boolean sync) {
		this.sync = sync;
	}
	
}
