package br.com.superafit.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="user")
public class User implements Serializable {

	private static final long serialVersionUID = -5145123520542504195L;

	@Id
	private String id;

	private String login;

	private String password;

	@OneToMany(mappedBy="user")
	private List<Device> devices;

	public User() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Device> getDevices() {
		return this.devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public Device addDevice(Device device) {
		getDevices().add(device);
		device.setUser(this);

		return device;
	}

	public Device removeDevice(Device device) {
		getDevices().remove(device);
		device.setUser(null);

		return device;
	}

}