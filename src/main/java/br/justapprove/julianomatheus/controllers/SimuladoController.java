package br.justapprove.julianomatheus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.justapprove.julianomatheus.models.Simulado;
import br.justapprove.julianomatheus.service.SimuladoService;

@RestController
@RequestMapping("/api/simulados")
public class SimuladoController {

	@Autowired
	private SimuladoService simService;
	
	@PostMapping("/simulados/save")	
	public Simulado saveSimulado(Simulado simulado) {
		return simService.saveSimulado(simulado);
	}
	@GetMapping("/simulados/read")
	public Simulado readSimulado(Simulado simulado) {
		return simService.readSimulado(simulado);
	}
	@PostMapping("/simulados/update")
	public Simulado updateSimulado(Simulado simulado) {
		return simService.updateSimulado(simulado, simulado.getId());
	}
	@DeleteMapping("/simulados/delete")
	public void deleteSimulado(Simulado simulado) {
		simService.deleteSimuladoEntity(simulado);
	}
}