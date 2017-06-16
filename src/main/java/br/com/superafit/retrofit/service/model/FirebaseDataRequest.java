package br.com.superafit.retrofit.service.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FirebaseDataRequest extends FirebaseRequest implements Serializable {

	private static final long serialVersionUID = 1884434005612965180L;
	
	private Map<String, Object> data = new HashMap<>();
		
	public void putData(String key, Object value) {
		this.data.put(key, value);
	}
	
	public Object getData() {
		return Collections.unmodifiableMap(data);
	}

}
