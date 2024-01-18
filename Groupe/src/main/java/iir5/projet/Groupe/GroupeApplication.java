package iir5.projet.Groupe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GroupeApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroupeApplication.class, args);
	}

}
