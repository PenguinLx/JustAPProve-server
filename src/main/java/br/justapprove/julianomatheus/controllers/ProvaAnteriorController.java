package br.justapprove.julianomatheus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.justapprove.julianomatheus.models.ProvaAnterior;
import br.justapprove.julianomatheus.service.ProvaAnteriorService;

@RestController
@RequestMapping("/prova")
public class ProvaAnteriorController {

	@Autowired
	private ProvaAnteriorService provaService;

	@PostMapping("/save")
	public ProvaAnterior saveProva(ProvaAnterior provaAnterior) {
		return provaService.saveProva(provaAnterior);
	}

	@GetMapping("/read")
	public ProvaAnterior readProva(ProvaAnterior provaAnterior) {
		return provaService.readProva(provaAnterior);
	}

	@PostMapping("/update")
	public ProvaAnterior updateProva(ProvaAnterior provaAnterior) {
		return provaService.updateProva(provaAnterior, provaAnterior.getId());
	}
	
	@DeleteMapping("/delete")
	public void deleteProva(ProvaAnterior provaAnterior) {
		provaService.deleteProvaAnteriorEntity(provaAnterior);
	}
}