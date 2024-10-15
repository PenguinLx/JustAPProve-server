package br.justapprove.julianomatheus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages = { "br.justapprove.julianomatheus", "models"} )
public class JustApProveApplication {

	public static void main(String[] args) {
		SpringApplication.run(JustApProveApplication.class, args);
	}
//Repository vs DAO: https://stackoverflow.com/questions/59797882/is-jparepository-interface-covers-the-responsibilities-of-dao-interface-in-sprin
	
	//usar service? : https://medium.com/@chandantechie/spring-boot-application-with-crud-operations-using-spring-data-jpa-and-mysql-23c8019660b1
	
	//possivel soluçao para os problemas de arquivo: https://www.youtube.com/watch?v=XUL60-Ke-L8
}
