package br.justapprove.julianomatheus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.justapprove.julianomatheus.models.Alternativa;
import br.justapprove.julianomatheus.repositories.AlternativaRepository;

@Service
public class AlternativaService {

	@Autowired
	private AlternativaRepository altRepository;
	
	
	public Alternativa saveAlternativa(@RequestBody Alternativa alternativa) {
		return altRepository.save(alternativa);
	}
	
	public Alternativa readAlternativa(@RequestBody Alternativa alternativa) {
		return altRepository.getReferenceById(alternativa.getId());
	}
	
	public Alternativa updateAlternativa(@RequestBody Alternativa alternativa, Integer id) {
		Alternativa alt = altRepository.findById(id).orElseThrow();
		alt.setDescricao(alternativa.getDescricao());
		alt.setCorreta(alternativa.isCorreta());
		return altRepository.save(alt);
	}
	
	public void deleteAlternativaEntity(@RequestBody Alternativa alternativa) {
		altRepository.delete(alternativa);
	}
}
