package br.com.superafit.enumeration;

public enum WeekDayEnum {

	SEGUNDA_FEIRA(1, "Segunda-feira"),
	TERCA_FEIRA(2, "Terça-feira"),
	QUARTA_FEIRA(3, "Quarta-feira"),
	QUINTA_FEIRA(4, "Quinta-feira"),
	SEXTA_FEIRA(5, "Sexta-feira"),
	SABADO_FEIRA(6, "Sábado"),
	DOMINGO_FEIRA(7, "Domingo");
	
	private final int code;
	private final String desc;
	
	private WeekDayEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getDesc() {
		return desc;
	}

	public static WeekDayEnum fromCode(int code) {
		for(WeekDayEnum wd : values()) {
			if(wd.getCode() == code) {
				return wd;
			}
		}
		
		throw new IllegalArgumentException();
	}
	
}

