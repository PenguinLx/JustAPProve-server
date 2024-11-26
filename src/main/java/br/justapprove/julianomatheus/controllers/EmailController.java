package br.justapprove.julianomatheus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.justapprove.julianomatheus.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	private EmailService emaservice;
	@PostMapping("/send")
	public void enviarEmail(@RequestParam("para") String para,@RequestParam("assunto") String assunto,@RequestParam("texto") String texto) {
		emaservice.enviarEmail(para, assunto, texto);
	}
	
	
}
