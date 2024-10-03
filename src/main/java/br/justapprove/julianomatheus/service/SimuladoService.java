package br.justapprove.julianomatheus.service;

import java.util.List;
import java.util.Optional;

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
	
	public Optional<Simulado> readSimulado(@RequestBody Integer id ) {
		
		return simRepository.findById(id);
	}
	
	public List<Simulado> readAllSimulados(){
		return simRepository.findAll();
	}
	
	public Simulado updateSimulado(@RequestBody Simulado simulado, Integer id) {
		Simulado sim = simRepository.findById(id).orElseThrow(); 
		sim.setQuestoes(simulado.getQuestoes());
		sim.setPontos(simulado.getPontos());
		return simRepository.save(sim);
	}
	
	public void deleteSimuladoById(@RequestBody Integer id) {
		simRepository.deleteById(id);
	}
	
	public void deleteAllSimulados() {
		simRepository.deleteAll();
	}
	
}
