package br.justapprove.julianomatheus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.justapprove.julianomatheus.models.Simulado;
import br.justapprove.julianomatheus.models.Usuario;
import br.justapprove.julianomatheus.service.SimuladoService;

@RestController
@RequestMapping("/simulados")
public class SimuladoController {

	@Autowired
	private SimuladoService simService;
	
	@PostMapping("/save")	
	public Simulado saveSimulado(Simulado simulado) {
		return simService.saveSimulado(simulado);
	}
	@GetMapping("/read")
	public Simulado readSimulado(Simulado simulado) {
		return simService.readSimulado(simulado);
	}
//	@GetMapping("/readAll")
//	public Simulado readSimuladoAll(Simulado simulado) {
//		return;
//	}
	@PostMapping("/update")
	public Simulado updateSimulado(Simulado simulado) {
		return simService.updateSimulado(simulado, simulado.getId());
	}
	@DeleteMapping("/delete")
	public void deleteSimulado(Simulado simulado) {
		simService.deleteSimuladoEntity(simulado);
	}
	
	@GetMapping("/teste")
	public String teste() {
		return "Eae amigos, como estão, tranquilos?";
	}
}