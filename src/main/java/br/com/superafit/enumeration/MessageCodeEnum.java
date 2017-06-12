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
	CREATE_DAY_TRAINING_REQUIRED_DATE(Constants.CREATE_DAY_TRAINING_REQUIRED_DATE),
	CREATE_DAY_TRAINING_REQUIRED_TYPE(Constants.CREATE_DAY_TRAINING_REQUIRED_TYPE),
	CREATE_DAY_TRAINING_REQUIRED_ROUNDS(Constants.CREATE_DAY_TRAINING_REQUIRED_ROUNDS),
	CREATE_DAY_TRAINING_REQUIRED_MOVEMENTS(Constants.CREATE_DAY_TRAINING_REQUIRED_MOVEMENTS),
	CREATE_DAY_TRAINING_REQUIRED_MOVEMENT(Constants.CREATE_DAY_TRAINING_REQUIRED_MOVEMENT),
	CREATE_DAY_TRAINING_REQUIRED_MOVEMENT_REPETITION(Constants.CREATE_DAY_TRAINING_REQUIRED_MOVEMENT_REPETITION),

	//create schedule
	CREATE_SCHEDULE_ALREADY_EXISTS(Constants.CREATE_SCHEDULE_ALREADY_EXISTS),
	CREATE_SCHEDULE_INVALID_SCHEDULE(Constants.CREATE_SCHEDULE_INVALID_SCHEDULE),
	CREATE_SCHEDULE_REQUIRED_WEEKDAY(Constants.CREATE_SCHEDULE_REQUIRED_WEEKDAY),
	CREATE_SCHEDULE_REQUIRED_START(Constants.CREATE_SCHEDULE_REQUIRED_START),
	CREATE_SCHEDULE_REQUIRED_END(Constants.CREATE_SCHEDULE_REQUIRED_END),
	CREATE_SCHEDULE_START_MUST_GREATER_THAN_END(Constants.CREATE_SCHEDULE_START_MUST_GREATER_THAN_END),
	CREATE_DAY_TRAINING_REQUIRED_SEQUENCE(Constants.CREATE_DAY_TRAINING_REQUIRED_SEQUENCE),
	CREATE_DAY_TRAINING_MIN_SEQUENCE(Constants.CREATE_DAY_TRAINING_MIN_SEQUENCE);
	
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
		public static final String CREATE_DAY_TRAINING_REQUIRED_SEQUENCE = "create_day_training_required_sequence";
		public static final String CREATE_DAY_TRAINING_MIN_SEQUENCE = "create_day_training_min_sequence";
		public static final String CREATE_DAY_TRAINING_DUPLICATE_REGISTER = "create_day_training_duplicate_register";
		
		//create movement
		public static final String CREATE_MOVEMENT_REQUIRED_NAME = "create_movement_required_name";
		public static final String CREATE_MOVEMENT_REQUIRED_TRANSLATE = "create_movement_required_translate";
		public static final String CREATE_MOVEMENT_ALREADY_EXISTS = "create_movement_already_exists";
		
		//create schedule
		public static final String CREATE_SCHEDULE_ALREADY_EXISTS = "create_schedule_already_exists";
		public static final String CREATE_SCHEDULE_INVALID_SCHEDULE = "create_schedule_invalid_schedule";
		public static final String CREATE_SCHEDULE_REQUIRED_WEEKDAY = "create_schedule_required_weekday";
		public static final String CREATE_SCHEDULE_REQUIRED_START = "create_schedule_required_start";
		public static final String CREATE_SCHEDULE_REQUIRED_END = "create_schedule_required_end";
		public static final String CREATE_SCHEDULE_START_MUST_GREATER_THAN_END = "create_schedule_start_must_greater_than_end";
		
	}
	
}
