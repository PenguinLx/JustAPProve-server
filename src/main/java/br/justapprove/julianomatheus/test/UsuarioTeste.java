package br.justapprove.julianomatheus.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.justapprove.julianomatheus.models.Usuario;
import br.justapprove.julianomatheus.repositories.UsuarioRepository;
import jakarta.annotation.PostConstruct;

@Component
public class UsuarioTeste {

	@Autowired
	private UsuarioRepository usrRepo;
	
	@PostConstruct
	private void run() {
		Usuario usr = new Usuario();
		//create
		usr.setEmail("cavalo#emailnumber1.com");
		usr.setUserName("Cavalo_Doido");
		usr.setSenha("hello_worlda");
		usrRepo.save(usr);
		//update
		
	
	}
	
	
}
