package br.justapprove.julianomatheus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;
@SpringBootApplication(scanBasePackages = { "br.justapprove.julianomatheus", "models"} )
public class JustApProveApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().filename("variables.env").load();
		System.setProperty("EMAIL_USER", dotenv.get("EMAIL_USER"));
	    System.setProperty("EMAIL_PASSWORD", dotenv.get("EMAIL_PASSWORD"));
		SpringApplication.run(JustApProveApplication.class, args);
	}
	
}
