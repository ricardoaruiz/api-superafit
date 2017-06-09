package br.com.superafit.retrofit.service.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FirebaseDataNotificationRequest extends FirebaseRequest implements Serializable {
	
	private static final long serialVersionUID = -3839541322366495242L;

	private final FirebaseNotification notification;
	
	private Map<String, Object> data = new HashMap<>();
	
	public FirebaseDataNotificationRequest(String title, String body) {
		super();
		this.notification = new FirebaseNotification(title, body);
	}

	public FirebaseNotification getNotification() {
		return notification;
	}

	public void putData(String key, Object value) {
		this.data.put(key, value);
	}
	
	public Object getData() {
		return Collections.unmodifiableMap(data);
	}

}
