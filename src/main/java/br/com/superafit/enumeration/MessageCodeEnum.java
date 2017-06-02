package br.com.superafit.enumeration;

public enum MessageCodeEnum {

	//login
	LOGIN_REQUIRED_LOGIN(Constants.LOGIN_REQUIRED_LOGIN),
	LOGIN_REQUIRED_PASSWORD(Constants.LOGIN_REQUIRED_PASSWORD),
	LOGIN_INVALID_PASSWORD_LENGTH(Constants.LOGIN_INVALID_PASSWORD_LENGTH),
	
	//create user
	CREATE_USER_REQUIRED_LOGIN(Constants.CREATE_USER_REQUIRED_LOGIN),	
	CREATE_USER_REQUIRED_PASSWORD1(Constants.CREATE_USER_REQUIRED_PASSWORD1),	
	CREATE_USER_INVALID_PASSWORD1_LENGTH(Constants.CREATE_USER_INVALID_PASSWORD1_LENGTH),	
	CREATE_USER_REQUIRED_PASSWORD2(Constants.CREATE_USER_REQUIRED_PASSWORD2),	
	CREATE_USER_INVALID_PASSWORD2_LENGTH(Constants.CREATE_USER_INVALID_PASSWORD2_LENGTH),	
	CREATE_USER_WRONG_PASSWORD(Constants.CREATE_USER_WRONG_PASSWORD), 	
	CREATE_USER_LOGIN_ALREAD_EXISTS(Constants.CREATE_USER_LOGIN_ALREAD_EXISTS),
	
	//create day training
	CREATE_DAY_TRAINING_REQUIRED_DATE("CREATE_DAY_TRAINING_REQUIRED_DATE"),
	CREATE_DAY_TRAINING_REQUIRED_TYPE("CREATE_DAY_TRAINING_REQUIRED_TYPE"),
	CREATE_DAY_TRAINING_REQUIRED_ROUNDS("CREATE_DAY_TRAINING_REQUIRED_ROUNDS"),
	CREATE_DAY_TRAINING_REQUIRED_MOVEMENTS("CREATE_DAY_TRAINING_REQUIRED_MOVEMENTS"),
	CREATE_DAY_TRAINING_REQUIRED_MOVEMENT("CREATE_DAY_TRAINING_REQUIRED_MOVEMENT"),
	CREATE_DAY_TRAINING_REQUIRED_MOVEMENT_REPETITION("CREATE_DAY_TRAINING_REQUIRED_MOVEMENT_REPETITION");
	
	private String code;
	
	private MessageCodeEnum(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}

	public interface Constants {
		
		//login
		public static final String LOGIN_REQUIRED_LOGIN = "login.required.login";
		public static final String LOGIN_REQUIRED_PASSWORD = "login.required.password";
		public static final String LOGIN_INVALID_PASSWORD_LENGTH = "login.invalid.password.length";
		
		//create user
		public static final String CREATE_USER_REQUIRED_LOGIN = "create.user.required.login";
		public static final String CREATE_USER_REQUIRED_PASSWORD1 = "create.user.required.password1";
		public static final String CREATE_USER_INVALID_PASSWORD1_LENGTH = "create.user.invalid.password1.length";
		public static final String CREATE_USER_REQUIRED_PASSWORD2 = "create.user.required.password2";
		public static final String CREATE_USER_INVALID_PASSWORD2_LENGTH = "create.user.invalid.password2.length";		
		public static final String CREATE_USER_WRONG_PASSWORD = "create_user_wrong_password";
		public static final String CREATE_USER_LOGIN_ALREAD_EXISTS = "create_user_already_exists";
		
		//create day training
		public static final String CREATE_DAY_TRAINING_REQUIRED_DATE = "create_day_training_required_date";
		public static final String CREATE_DAY_TRAINING_REQUIRED_TYPE = "create_day_training_required_type";
		public static final String CREATE_DAY_TRAINING_REQUIRED_ROUNDS = "create_day_training_required_rounds";
		public static final String CREATE_DAY_TRAINING_MIN_ROUNDS = "create_day_training_min_rounds";
		public static final String CREATE_DAY_TRAINING_REQUIRED_MOVEMENTS = "create_day_training_required_movements";
		public static final String CREATE_DAY_TRAINING_REQUIRED_MOVEMENT = "create_day_training_required_movement";
		public static final String CREATE_DAY_TRAINING_REQUIRED_MOVEMENT_REPETITION = "create_day_training_required_movement_repetition";
		public static final String CREATE_DAY_TRAINING_REQUIRED_MOVEMENT_MIN_REPETITION = "create_day_training_required_movement_min_repetition";
		
	}
	
}
