package br.com.fabiosp1991.preparacao;

import br.com.fabiosp1991.preparacao.services.impl.ImovelServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"br.com.fabiosp1991"})
@EnableFeignClients
public class PreparacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PreparacaoApplication.class, args);
	}

	public void teste(){
		ImovelServiceImpl imovelService = new ImovelServiceImpl();
		imovelService.getImovelApelido("casa");
	}

}
