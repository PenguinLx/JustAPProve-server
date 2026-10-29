package br.justapprove.julianomatheus.test;

import br.justapprove.julianomatheus.controllers.UsuarioController;
import br.justapprove.julianomatheus.service.EmailService;
import br.justapprove.julianomatheus.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import br.justapprove.julianomatheus.models.Usuario;
import br.justapprove.julianomatheus.repositories.UsuarioRepository;
import jakarta.annotation.PostConstruct;

@Component
public class UsuarioTeste {

	private UsuarioRepository usrRepo;
	
	@PostConstruct
	private void run() {
	var emailService = new EmailService(new JavaMailSenderImpl());
	var usuarioService = new UsuarioService(usrRepo, emailService);
	var usuarioController = new UsuarioController(usuarioService);
		//Usuario usr = new Usuario();
		//create
//		usr.setEmail("cavalo#emailnumber1.com");
//		usr.setApelido("Cavalo_Doido");
//		usr.setSenha("hello_worlda");
//		usrRepo.save(usr);
		//update
		
	
	}
	
	
}
