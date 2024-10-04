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

import br.justapprove.julianomatheus.models.Simulado;
import br.justapprove.julianomatheus.service.SimuladoService;

@RestController
@RequestMapping("/simulado")
public class SimuladoController {

	@Autowired
	private SimuladoService simService;
	
	@PostMapping("/save")	
	public Simulado saveSimulado(Simulado simulado) {
		return simService.saveSimulado(simulado);
	}
	@GetMapping("/read/{id}")
	public Simulado readSimulado(Integer id) {
		return simService.readSimulado(id).orElseThrow();
	}
	@GetMapping("/readAll")
	public List<Simulado> readSimuladoAll() {
		return simService.readAllSimulados();
	}
	@PutMapping("/update/{id}")
	public Simulado updateSimulado(@PathVariable("id") Integer id, @RequestBody Simulado simulado) {
		return simService.updateSimulado(id, simulado);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteSimulado(@PathVariable("id") Integer id) {
		simService.deleteSimuladoById(id);
	}
	
	@DeleteMapping("/deleteAll")
	public void deleteAllSimulado() {
		simService.deleteAllSimulados();
	}
	
	@GetMapping("/teste")
	public String teste() {
		return "Eae amigos, como estão, tranquilos?";
	}
}