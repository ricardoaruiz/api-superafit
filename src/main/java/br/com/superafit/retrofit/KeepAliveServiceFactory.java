package br.com.superafit.retrofit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.superafit.retrofit.service.KeepAliveFrontendService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Service
public class KeepAliveServiceFactory {

	@Value("${url.frontend}")
	private String urlFrontend;
	
	private Retrofit retrofit;
	
	public KeepAliveServiceFactory() {
		
	}
	
	@PostConstruct
	private void config() {
		HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
		OkHttpClient client = new OkHttpClient.Builder()
				.addInterceptor(interceptor)
				.build();
		
		this.retrofit = new Retrofit.Builder()
			.baseUrl(urlFrontend)
			.client(client)
			.addConverterFactory(JacksonConverterFactory.create())
			.build();
	}
		
	public KeepAliveFrontendService getKeepAliveFrontendService() {
		return this.retrofit.create(KeepAliveFrontendService.class);
	}
	
}
