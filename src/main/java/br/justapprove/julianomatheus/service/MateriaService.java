package br.justapprove.julianomatheus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.justapprove.julianomatheus.models.Materia;
import br.justapprove.julianomatheus.models.TipoMateria;
import br.justapprove.julianomatheus.repositories.MateriaRepository;

@Service
public class MateriaService {

	@Autowired
	private MateriaRepository matRepository; 
	
	public Materia saveMateria(Materia materia) {
		return matRepository.save(materia);
	}
	
	public Optional<Materia> readMateria(@RequestBody Integer id) {
		return matRepository.findById(id);
	}
	
	public List<Materia> readAllMaterias(){
		return matRepository.findAll();
	}
	
//	public Material readMaterialByMateriaId(){
//		
//	}
	public List<Materia> readAllMateriasByTipo(String tipo){
		TipoMateria tipoM;
		switch (tipo) {
		
		case "PORTUGUES":
			tipoM = TipoMateria.PORTUGUES;
			break;
		case "MATEMATICA":
			tipoM = TipoMateria.MATEMATICA;
		break;
		
		case "GEOGRAFIA":
			tipoM = TipoMateria.GEOGRAFIA;
			break;
			
		case "HISTORIA":
			tipoM =  TipoMateria.HISTORIA;
			break;
			
		default:
			tipoM = TipoMateria.DESCONHECIDO;
			break;
		}
			return matRepository.findByTipo(tipoM, Sort.by(Sort.Direction.ASC, "nome"));
	}
	
	public Materia updateMateria(Integer id, Materia materia) {
		
		Materia mat = matRepository.findById(id).orElseThrow();
		mat.setNome(materia.getNome());
		mat.setTipo(materia.getTipo());
		mat.setMaterial(materia.getMaterial());
		return matRepository.save(mat);
	}
	
	public void deleteMateriaById(@RequestBody Integer id) {
		matRepository.deleteById(id);
	}
	
	
}
