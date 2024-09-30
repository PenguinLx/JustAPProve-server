package br.justapprove.julianomatheus.service;

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

	public ProvaAnterior readProva(@RequestBody ProvaAnterior provaAnterior) {
		return provaRepository.getReferenceById(provaAnterior.getId());
	}

	public ProvaAnterior updateProva(@RequestBody ProvaAnterior provaAnterior, Integer id) {
		
	ProvaAnterior prova = provaRepository.findById(id).orElseThrow();
	prova.setTitulo(provaAnterior.getTitulo());
	prova.setPdf(provaAnterior.getPdf());
	return provaRepository.save(prova);
}
	public void deleteProvaAnteriorEntity(@RequestBody ProvaAnterior provaAnterior) {
		
		provaRepository.delete(provaAnterior);
	}

}
