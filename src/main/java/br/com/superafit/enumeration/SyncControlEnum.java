package br.com.superafit.enumeration;

public enum SyncControlEnum {

	SCHEDULE(SyncEntityConstant.SCHEDULE),
	TRAINNING(SyncEntityConstant.TRAINNING);
	
	private final String value;
	
	private SyncControlEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public interface SyncEntityConstant {
		public static final String SCHEDULE = "SCHEDULE";
		public static final String TRAINNING = "TRAINNING";
	}
	
}
