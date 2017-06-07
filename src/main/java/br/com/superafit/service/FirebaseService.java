package br.com.superafit.service;

import java.io.IOException;
import java.net.HttpURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.superafit.retrofit.FirebaseServiceFactory;
import br.com.superafit.retrofit.service.model.FirebaseValidationRequest;
import br.com.superafit.retrofit.service.model.FirebaseResponse;
import retrofit2.Call;
import retrofit2.Response;

@Service
public class FirebaseService {

	@Value("${fcm.server.key}")
	private String fcmServerKey;
	
	@Autowired
	private FirebaseServiceFactory firebaseServiceFactory;
	
	public boolean validateFirebaseAccess() {

		String authorization = "key=" + fcmServerKey;
		
		FirebaseValidationRequest request = new FirebaseValidationRequest();
		request.setRegistrationIds(new String[] {fcmServerKey} );
		
		Call<FirebaseResponse> callValidate = firebaseServiceFactory.getFirebaseService().send(authorization, request);
		
		try {
			Response<FirebaseResponse> response = callValidate.execute();
			if(response.code() == HttpURLConnection.HTTP_UNAUTHORIZED) {
				return false;
			}
			return true;
		} catch (IOException e) {
			return false;
		}		
		
	}
	
	
	
}
