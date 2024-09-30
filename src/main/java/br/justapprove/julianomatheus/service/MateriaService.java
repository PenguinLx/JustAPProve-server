package br.justapprove.julianomatheus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.justapprove.julianomatheus.models.Materia;
import br.justapprove.julianomatheus.repositories.MateriaRepository;

@Service
public class MateriaService {

	@Autowired
	private MateriaRepository matRepository; 
	
	public Materia saveMateria(@RequestBody Materia materia) {
		return matRepository.save(materia);
	}
	
	public Materia readMateria(@RequestBody Materia materia) {
		
		return matRepository.getReferenceById(materia.getId());
	}
	
	public Materia updateMateria(@RequestBody  Materia materia, Integer id) {
		
		Materia mat = matRepository.findById(id).orElseThrow();
		mat.setNome(materia.getNome());
		mat.setDescricao(materia.getDescricao());
		mat.setTipo(materia.getTipo());
		mat.setMateriais(materia.getMateriais());
		return matRepository.save(mat);
	}
	
	public void deleteMateriaEntity(@RequestBody Materia materia) {
		matRepository.delete(materia);
	}
}
