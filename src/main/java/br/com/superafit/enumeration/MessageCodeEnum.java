package br.com.superafit.enumeration;

public enum MessageCodeEnum {

	CREATE_USER_WRONG_PASSWORD(Constants.CREATE_USER_WRONG_PASSWORD), 
	
	CREATE_USER_LOGIN_ALREAD_EXISTS(Constants.CREATE_USER_LOGIN_ALREAD_EXISTS);
	
	private String code;
	
	private MessageCodeEnum(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}

	public interface Constants {
		public final String CREATE_USER_WRONG_PASSWORD = "create_user_wrong_password";
		public final String CREATE_USER_LOGIN_ALREAD_EXISTS = "create_user_already_exists";
	}
	
}
