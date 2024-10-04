package br.justapprove.julianomatheus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.justapprove.julianomatheus.models.ProvaAnterior;
import br.justapprove.julianomatheus.repositories.ProvaAnteriorRepository;

@Service
public class ProvaAnteriorService {

	@Autowired
	private ProvaAnteriorRepository provaRepository;

	public ProvaAnterior saveProva(@RequestBody ProvaAnterior provaAnterior) {
		return provaRepository.save(provaAnterior);
	}

	public Optional<ProvaAnterior> readProva(@RequestBody Integer id) {
		return provaRepository.findById(id);
	}
	
	public List<ProvaAnterior> readAllProvas(){
		return provaRepository.findAll();
	}

	public ProvaAnterior updateProva(@RequestBody Integer id, ProvaAnterior provaAnterior) {
		
	ProvaAnterior prova = provaRepository.findById(id).orElseThrow();
	prova.setTitulo(provaAnterior.getTitulo());
	prova.setPdf(provaAnterior.getPdf());
	return provaRepository.save(prova);
}
	public void deleteProvaAnteriorById(@RequestBody Integer id) {
		provaRepository.deleteById(id);
	}
	
	public void deleteAllProvaAnterior() {
		provaRepository.deleteAll();
	}

}
