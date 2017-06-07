package br.com.superafit.model;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class DevicePK implements Serializable {

	private static final long serialVersionUID = -8222571396030496880L;

	@Column(name="user_id", insertable=false, updatable=false)
	private String userId;

	private String token;

	public DevicePK() {
	}
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getToken() {
		return this.token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DevicePK)) {
			return false;
		}
		DevicePK castOther = (DevicePK)other;
		return 
			this.userId.equals(castOther.userId)
			&& this.token.equals(castOther.token);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userId.hashCode();
		hash = hash * prime + this.token.hashCode();
		
		return hash;
	}
}