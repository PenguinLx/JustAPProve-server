package br.justapprove.julianomatheus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping("/read/{id}")
	public ProvaAnterior readProva(Integer id) {
		return provaService.readProva(id).orElseThrow();
	}
	
	@GetMapping("/readAll")
	public List<ProvaAnterior> readAllProvas(){
		return provaService.readAllProvas();
	}

	@PutMapping("/update/{id}")
	public ProvaAnterior updateProva(@PathVariable("id") Integer id, @RequestBody ProvaAnterior provaAnterior) {
		return provaService.updateProva(id, provaAnterior);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteProva(@PathVariable("id") Integer id) {
		provaService.deleteProvaAnteriorById(id);
	}
	
	@DeleteMapping("/deleteAll")
	public void deleteAllProvaAnterior() {
		provaService.deleteAllProvaAnterior();
	}
}