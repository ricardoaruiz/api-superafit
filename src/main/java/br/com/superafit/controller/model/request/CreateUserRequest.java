package br.com.superafit.controller.model.request;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.superafit.enumeration.MessageCodeEnum;
import io.swagger.annotations.ApiModelProperty;

public class CreateUserRequest implements Serializable {

	private static final long serialVersionUID = -9184577883248586382L;

	@ApiModelProperty(example="myuser", required=true)
	@NotEmpty(message=MessageCodeEnum.Constants.CREATE_USER_REQUIRED_LOGIN)
	private String login;
	
	@ApiModelProperty(example="123456", required=true)
	@Size(min=6, max=6, message=MessageCodeEnum.Constants.CREATE_USER_INVALID_PASSWORD1_LENGTH)
	@NotEmpty(message=MessageCodeEnum.Constants.CREATE_USER_REQUIRED_PASSWORD1)
	private String password1;

	@ApiModelProperty(example="123456", required=true)
	@Size(min=6, max=6, message=MessageCodeEnum.Constants.CREATE_USER_INVALID_PASSWORD2_LENGTH)
	@NotEmpty(message=MessageCodeEnum.Constants.CREATE_USER_REQUIRED_PASSWORD2)
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
