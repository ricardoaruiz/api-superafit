package br.com.superafit.retrofit.service.model;

import java.io.Serializable;

public class FirebaseNotification implements Serializable {

	private static final long serialVersionUID = -5800731222666648684L;

	private final String title;
	
	private final String body;

	private String icon;
	
	private String sound;
		
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

	public void setIcon(String icon) {
		this.icon = icon;		
	}

	public String getIcon() {
		return icon == null ? "ic_notifications" : icon;
	}

	public String getSound() {
		if(sound == null) {
			return "default";
		}
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}
	
}
