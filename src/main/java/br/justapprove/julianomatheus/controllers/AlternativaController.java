package br.justapprove.julianomatheus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.justapprove.julianomatheus.models.Alternativa;
import br.justapprove.julianomatheus.service.AlternativaService;

@RestController
@RequestMapping("/api/alternativa")
public class AlternativaController {

	@Autowired
	private AlternativaService altService;

	@PostMapping("/alternativa/save")
	public Alternativa saveAlternativa(Alternativa alternativa) {
		return altService.saveAlternativa(alternativa);
	}

	@GetMapping("alternativa/read")
	public Alternativa readAlternativa(Alternativa alternativa) {
		return altService.readAlternativa(alternativa);
	}

	@PostMapping("/alternativa/update")
	public Alternativa updateAlternativa(Alternativa alternativa) {
		return altService.updateAlternativa(alternativa, alternativa.getId());
	}

	@DeleteMapping("alternativa/delete")
	public void deleteAlternativa(Alternativa alternativa) {
		altService.deleteAlternativaEntity(alternativa);
	}
}