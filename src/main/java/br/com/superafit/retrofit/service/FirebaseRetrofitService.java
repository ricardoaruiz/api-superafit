package br.com.superafit.retrofit.service;

import br.com.superafit.retrofit.service.model.FirebaseResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface FirebaseRetrofitService {

	@Headers("Content-Type: application/json")
	@POST("send")
	Call<FirebaseResponse> send(
			@Header("Authorization") String authorization,
			@Body Object request);
	
}
