package br.justapprove.julianomatheus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages = { "br.justapprove.julianomatheus", "models"} )
public class JustApProveApplication {

	public static void main(String[] args) {
		SpringApplication.run(JustApProveApplication.class, args);
	}
	
//Repository vs DAO: https://stackoverflow.com/questions/59797882/is-jparepository-interface-covers-the-responsibilities-of-dao-interface-in-sprin
}
