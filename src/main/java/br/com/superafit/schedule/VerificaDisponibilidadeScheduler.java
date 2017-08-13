package br.com.superafit.schedule;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.superafit.retrofit.KeepAliveServiceFactory;
import retrofit2.Call;
import retrofit2.Response;

@Component
public class VerificaDisponibilidadeScheduler {

	private final Logger LOG = LoggerFactory.getLogger(VerificaDisponibilidadeScheduler.class);

	@Value("${enable.verify.available.resources}")
	private String enableVerifyAvailableResources;
	
	@Autowired
	private KeepAliveServiceFactory serviceFactory;
	
	@Scheduled(fixedRate=480000)
	public void verificaDisponibillidade() {
		if (isEnableVerifyAvailableResouces()) {
			try {
				LOG.info("Obtendo os dados de treino do frontend para verificação...");
				Call<Void> call = serviceFactory.getKeepAliveFrontendService().isOn();
				Response<Void> response = call.execute();
				LOG.info("Http code: " + response.code());
			} catch (IOException e) {
				LOG.error(e.getMessage(), e);
			}
		}
	}
	
	private boolean isEnableVerifyAvailableResouces() {
		return Boolean.valueOf(enableVerifyAvailableResources);
	}
	
}
