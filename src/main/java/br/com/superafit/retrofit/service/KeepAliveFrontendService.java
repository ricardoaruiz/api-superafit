package br.com.superafit.retrofit.service;

import retrofit2.Call;
import retrofit2.http.GET;

public interface KeepAliveFrontendService {

	@GET("app/trainning-available")
	Call<Void> isOn();
	
}
