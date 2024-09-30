package br.justapprove.julianomatheus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.justapprove.julianomatheus.models.Simulado;
import br.justapprove.julianomatheus.repositories.SimuladoRepository;

@Service
public class SimuladoService {

	@Autowired
	private SimuladoRepository simRepository;
	
	
	public Simulado saveSimulado(@RequestBody Simulado simulado) {
		return simRepository.save(simulado);
	}
	
	public Simulado readSimulado(@RequestBody Simulado simulado) {
		
		return simRepository.getReferenceById(simulado.getId());
	}
	
	public Simulado updateSimulado(@RequestBody Simulado simulado, Integer id) {
		Simulado sim = simRepository.findById(id).orElseThrow(); 
		sim.setQuestoes(simulado.getQuestoes());
		sim.setPontos(simulado.getPontos());
		return simRepository.save(sim);
	}
	
	public void deleteSimuladoEntity(@RequestBody Simulado simulado) {
		simRepository.delete(simulado);
	}
	
	
}
