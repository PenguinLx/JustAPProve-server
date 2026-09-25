package br.justapprove.julianomatheus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;
@SpringBootApplication(scanBasePackages = { "br.justapprove.julianomatheus", "models"} )
public class JustApProveApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().directory("./").filename("variables.env").load();
		System.setProperty("EMAIL_USER", dotenv.get("EMAIL_USER"));
	    System.setProperty("EMAIL_PASS", dotenv.get("EMAIL_PASS"));
	    System.setProperty("EMAIL_HOST", dotenv.get("EMAIL_HOST"));
	    System.setProperty("EMAIL_PORT", dotenv.get("EMAIL_PORT"));
	    System.setProperty("DB_USER", dotenv.get("DB_USER"));
	    System.setProperty("DB_URL", dotenv.get("DB_URL"));
	    System.setProperty("DB_PASS", dotenv.get("DB_PASS"));
	    
	    
		SpringApplication.run(JustApProveApplication.class, args);
	}
	
}
