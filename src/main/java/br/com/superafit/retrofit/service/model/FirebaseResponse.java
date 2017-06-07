package br.com.superafit.retrofit.service.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class FirebaseResponse implements Serializable {

	private static final long serialVersionUID = 6747510076848489251L;

	@JsonProperty("multicast_id")
	private Long multicastId;
	
	private Integer success;
	
	private Integer failure;
	
	@JsonProperty("canonical_ids")
	private Integer canonicalIds;
	
	private List<FirebaseValidationResultResponse> results;

	public Long getMulticastId() {
		return multicastId;
	}

	public void setMulticastId(Long multicastId) {
		this.multicastId = multicastId;
	}

	public Integer getSuccess() {
		return success;
	}

	public void setSuccess(Integer success) {
		this.success = success;
	}

	public Integer getFailure() {
		return failure;
	}

	public void setFailure(Integer failure) {
		this.failure = failure;
	}

	public Integer getCanonicalIds() {
		return canonicalIds;
	}

	public void setCanonicalIds(Integer canonicalIds) {
		this.canonicalIds = canonicalIds;
	}

	public List<FirebaseValidationResultResponse> getResults() {
		return results;
	}

	public void setResults(List<FirebaseValidationResultResponse> results) {
		this.results = results;
	}
	
}
