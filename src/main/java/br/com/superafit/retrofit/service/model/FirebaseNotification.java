package br.com.superafit.retrofit.service.model;

import java.io.Serializable;

public class FirebaseNotification implements Serializable {

	private static final long serialVersionUID = -5800731222666648684L;

	private final String title;
	
	private final String body;
	
	public FirebaseNotification(String title, String body) {
		this.title = title;
		this.body = body;
	}

	public String getTitle() {
		return title;
	}

	public String getBody() {
		return body;
	}
	
}
