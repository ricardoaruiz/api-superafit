package br.com.superafit.retrofit.service.model;

import java.io.Serializable;

public class FirebaseNotificationRequest extends FirebaseRequest implements Serializable {

	private static final long serialVersionUID = 3778278386911215084L;

	private final FirebaseNotification notification;
	
	public FirebaseNotificationRequest(String title, String body) {
		super();
		this.notification = new FirebaseNotification(title, body);
	}

	public FirebaseNotification getNotification() {
		return notification;
	}
	
}
