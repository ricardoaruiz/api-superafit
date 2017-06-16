package br.com.superafit.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.superafit.model.Device;
import br.com.superafit.retrofit.FirebaseServiceFactory;
import br.com.superafit.retrofit.service.model.FirebaseRequest;
import br.com.superafit.retrofit.service.model.FirebaseResponse;
import br.com.superafit.retrofit.service.model.FirebaseValidationRequest;
import retrofit2.Call;
import retrofit2.Response;

@Service
public class FirebaseService {

	private final Logger LOG = LoggerFactory.getLogger(FirebaseService.class);
	
	@Value("${fcm.server.key}")
	private String fcmServerKey;
	
	private String authorization;
	
	@Autowired
	private FirebaseServiceFactory firebaseServiceFactory;
	
	@Autowired
	private DeviceService deviceService;
		
	@PostConstruct
	public void postConstruct() {
		authorization = "key=" + fcmServerKey;
	}
	
	public boolean validateFirebaseAccess() {
		try {			
			FirebaseValidationRequest request = new FirebaseValidationRequest();
			request.setRegistrationIds(new String[] {fcmServerKey} );
					
			Call<FirebaseResponse> callValidate = firebaseServiceFactory.getFirebaseService().send(authorization, request);
		
			Response<FirebaseResponse> response = callValidate.execute();
			if(response.code() == HttpURLConnection.HTTP_UNAUTHORIZED) {
				return false;
			}
			return true;
		} catch (IOException e) {
			LOG.error("Firebase Server Key pode não estar correto. Verifique!", e);
			return false;
		}
	}
		
	public void send(FirebaseRequest request) {		
		List<Device> listAll = deviceService.listAll();
		for (Device device : listAll) {
			request.setTo(device.getId().getToken());
			callSend(request);			
		}
	}

	private Response<FirebaseResponse> callSend(FirebaseRequest request) {
		try {
			Call<FirebaseResponse> callSend = firebaseServiceFactory.getFirebaseService().send(authorization, request);
			
			//Somente para logar a request
			ObjectMapper om = new ObjectMapper();
			String json = om.writeValueAsString(request);			
			LOG.info("Request Firebase: " + json);
			
			Response<FirebaseResponse> response = callSend.execute();
			
			LOG.info("Resposta Firebase: " + om.writeValueAsString(response.body()));
			
			return response;
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
			return null;
		}		
	}
}
