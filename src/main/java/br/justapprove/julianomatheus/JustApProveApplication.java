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
//Repository vs DAO: https://stackoverflow.com/questions/59797882/is-jparepository-interface-covers-the-responsibilities-of-dao-interface-in-sprin
	
	//usar service? : https://medium.com/@chandantechie/spring-boot-application-with-crud-operations-using-spring-data-jpa-and-mysql-23c8019660b1
	
	//possivel soluçao para os problemas de arquivo: https://www.youtube.com/watch?v=XUL60-Ke-L8

/*possiveis soluções de json parser deserialization error:
	https://devwithus.com/can-not-deserialize-instance-of-java-util-arraylist-start-object-token/
	
	https://stackoverflow.com/questions/10978748/jackson-deserialization-with-contained-arraylistt
	
	https://www.geeksforgeeks.org/how-to-convert-an-arraylist-of-objects-to-a-json-array-in-java/
	
	https://stackoverflow.com/questions/20837856/can-not-deserialize-instance-of-java-util-arraylist-out-of-start-object-token
	
	https://www.javatpoint.com/deserialize-to-collection-and-array-in-jackson
	
	https://stackoverflow.com/questions/9829403/deserialize-json-to-arraylistpojo-using-jackson
	
	https://www.youtube.com/watch?v=3ONGz-eSWlg&t=79s
	
	https://pt.stackoverflow.com/questions/375677/como-corrigir-o-erro-cannot-deserialize-from-object-value-no-delegate-or-prop
	
	SIM, EU PROCUREI EM TUDO ISSO E NÃO ACHEI A SOLUÇÃO ;-;
	*/
}
