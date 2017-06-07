package br.com.superafit.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="device")
public class Device implements Serializable {
	
	private static final long serialVersionUID = 4617965438439456719L;

	@EmbeddedId
	private DevicePK id;

	@ManyToOne
	@MapsId("userId")
	private User user;

	public Device() {
	}

	public DevicePK getId() {
		return this.id;
	}

	public void setId(DevicePK id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}