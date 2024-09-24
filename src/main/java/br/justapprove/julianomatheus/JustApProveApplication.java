package br.justapprove.julianomatheus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages = { "br.justapprove.julianomatheus", "models"} )
public class JustApProveApplication {

	public static void main(String[] args) {
		SpringApplication.run(JustApProveApplication.class, args);
	}
	//INSTALAR LOMBOK: https://projectlombok.org/p2(eclipse "install new software")
	

}
