package br.justapprove.julianomatheus.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.justapprove.julianomatheus.service.EmailService;
@RequiredArgsConstructor
@RestController
@RequestMapping("/email")
public class EmailController {


	private final EmailService emaservice;
	@PostMapping("/send")
	public void enviarEmail(@RequestParam("para") String para,@RequestParam("assunto") String assunto,@RequestParam("texto") String texto) {
		emaservice.enviarEmail(para, assunto, texto);
	}
	
	
}
