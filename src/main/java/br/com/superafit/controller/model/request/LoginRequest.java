package br.com.superafit.controller.model.request;

import java.io.Serializable;

public class LoginRequest implements Serializable {

	private static final long serialVersionUID = 1205720579537231838L;

	private String login;
	
	private String password;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
