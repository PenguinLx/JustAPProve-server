package br.justapprove.julianomatheus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.justapprove.julianomatheus.models.Alternativa;
import br.justapprove.julianomatheus.service.AlternativaService;

@RestController
@RequestMapping("/alternativa")
public class AlternativaController {

	@Autowired
	private AlternativaService altService;

	@PostMapping("/save")
	public Alternativa saveAlternativa(Alternativa alternativa) {
		return altService.saveAlternativa(alternativa);
	}

	@GetMapping("/read/{id}")
	public Alternativa readAlternativa(Integer id) {
		return altService.readAlternativa(id).orElseThrow();
	}
	
	@GetMapping("/readAll")
	public List<Alternativa> readAllAlternativas(){
		return altService.readAllAlternativa();
	}

	@PutMapping("/update")
	public Alternativa updateAlternativa(Alternativa alternativa) {
		return altService.updateAlternativa(alternativa, alternativa.getId());
	}

	@DeleteMapping("/delete/{id}")
	public void deleteAlternativaById(@PathVariable("id") Integer id) {
		altService.deleteAlternativaById(id);
	}
	
	@DeleteMapping("/deleteAll")
	public void deleteAllAlternativa() {
		altService.deleteAllAlternativa();
	}
}