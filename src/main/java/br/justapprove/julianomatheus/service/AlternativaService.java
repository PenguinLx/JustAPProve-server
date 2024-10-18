package br.justapprove.julianomatheus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.justapprove.julianomatheus.models.Alternativa;
import br.justapprove.julianomatheus.repositories.AlternativaRepository;

@Service
public class AlternativaService {

	@Autowired
	private AlternativaRepository altRepository;
	
	
	public Alternativa saveAlternativa( Alternativa alternativa) {
		return altRepository.save(alternativa);
	}
	
	public Optional<Alternativa> readAlternativa(@RequestBody Integer id) {
		return altRepository.findById(id);
	}
	
	public List<Alternativa> readAllAlternativa(){
		return altRepository.findAll();
	}
	
	public Alternativa updateAlternativa(@RequestBody Alternativa alternativa, Integer id) {
		Alternativa alt = altRepository.findById(id).orElseThrow();
		alt.setDescricao(alternativa.getDescricao());
		alt.setCorreta(alternativa.isCorreta());
		return altRepository.save(alt);
	}
	
	public void deleteAlternativaById(@RequestBody Integer id) {
		altRepository.deleteById(id);
	}
	
	
}
