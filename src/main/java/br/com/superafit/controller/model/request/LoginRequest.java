package br.com.superafit.controller.model.request;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.superafit.enumeration.MessageCodeEnum;
import io.swagger.annotations.ApiModelProperty;

public class LoginRequest implements Serializable {

	private static final long serialVersionUID = 1205720579537231838L;

	@ApiModelProperty(example="myuser", required=true)
	@NotEmpty(message=MessageCodeEnum.Constants.LOGIN_REQUIRED_LOGIN)
	private String login;
	
	@ApiModelProperty(example="123456", required=true)
	@Size(min=6, max=6, message=MessageCodeEnum.Constants.LOGIN_INVALID_PASSWORD_LENGTH)
	@NotEmpty(message=MessageCodeEnum.Constants.LOGIN_REQUIRED_PASSWORD)
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
