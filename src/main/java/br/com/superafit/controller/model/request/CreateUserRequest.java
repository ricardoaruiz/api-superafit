package br.com.superafit.controller.model.request;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class CreateUserRequest implements Serializable {

	private static final long serialVersionUID = -9184577883248586382L;

	@NotEmpty(message="create.user.required.login")
	private String login;
	
	@Size(min=6, max=6, message="create.user.invalid.password1.length")
	@NotEmpty(message="create.user.required.password1")
	private String password1;

	@Size(min=6, max=6, message="create.user.invalid.password2.length")
	@NotEmpty(message="create.user.required.password2")
	private String password2;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
}
