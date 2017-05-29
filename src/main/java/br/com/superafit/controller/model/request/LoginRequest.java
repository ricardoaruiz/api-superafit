package br.com.superafit.controller.model.request;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginRequest implements Serializable {

	private static final long serialVersionUID = 1205720579537231838L;

	@NotEmpty(message="login.required.login")
	private String login;
	
	@Size(min=6, max=6, message="login.invalid.password.length")
	@NotEmpty(message="login.required.password")
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
