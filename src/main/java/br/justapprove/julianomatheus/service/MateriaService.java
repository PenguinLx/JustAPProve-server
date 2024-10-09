package br.justapprove.julianomatheus.service;

import java.util.List;
import java.util.Optional;

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
	
	public Optional<Materia> readMateria(@RequestBody Integer id) {
		return matRepository.findById(id);
	}
	
	public List<Materia> readAllMaterias(){
		return matRepository.findAll();
	}
	
	public Materia updateMateria(@RequestBody  Materia materia, Integer id) {
		
		Materia mat = matRepository.findById(id).orElseThrow();
		mat.setNome(materia.getNome());
		mat.setDescricao(materia.getDescricao());
		mat.setTipo(materia.getTipo());
		mat.setMateriais(materia.getMateriais());
		return matRepository.save(mat);
	}
	
	public void deleteMateriaById(@RequestBody Integer id) {
		matRepository.deleteById(id);
	}
	
	public void deleteAllMateria() {
		matRepository.deleteAll();
	}
}
