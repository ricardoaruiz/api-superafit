package br.com.superafit.retrofit;

import org.springframework.stereotype.Service;

import br.com.superafit.retrofit.service.FirebaseRetrofitService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Service
public class FirebaseServiceFactory {

	private static final String FIREBASE_URL = "https://fcm.googleapis.com/fcm/";
	
	private Retrofit retrofit;
	
	public FirebaseServiceFactory() {
		
		HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
		OkHttpClient client = new OkHttpClient.Builder()
				.addInterceptor(interceptor)
				.build();
		
		this.retrofit = new Retrofit.Builder()
			.baseUrl(FIREBASE_URL)
			.addConverterFactory(JacksonConverterFactory.create())
			.build();
	}
		
	public FirebaseRetrofitService getFirebaseService() {
		return this.retrofit.create(FirebaseRetrofitService.class);
	}
	
}
