package iir5.projet.Professeur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProfesseurApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfesseurApplication.class, args);
	}

}
