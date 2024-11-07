package br.justapprove.julianomatheus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.justapprove.julianomatheus.models.Materia;
import br.justapprove.julianomatheus.models.Material;
import br.justapprove.julianomatheus.models.TipoMateria;
import br.justapprove.julianomatheus.repositories.MateriaRepository;

@Service
public class MateriaService {

	@Autowired
	private MateriaRepository matRepository; 
	
	public Materia saveMateria(Materia materia) {
		List<Material> materialList = new ArrayList<>();
		for(int i = 0; i < materia.getMateriais().size(); i++) {
			Material matl = new Material();

		matl.setDescricao(materia.getMateriais().get(i).getDescricao());
		matl.setVideoEmbedd(materia.getMateriais().get(i).getVideoEmbedd());
		matl.setMateria(materia);
		materialList.add(matl);
		}
		
		materia.setMateriais(materialList);
		return matRepository.save(materia);
	}
	
	public Optional<Materia> readMateria(@RequestBody Integer id) {
		return matRepository.findById(id);
	}
	
	public List<Materia> readAllMaterias(){
		return matRepository.findAll();
	}
	public List<Materia> readAllMateriasByTipo(String tipo){
			return matRepository.findByTipo(tipo);
				
//				for(Materia materia: listMateria) {
//					if(materia.getTipo() == tipo) {					
//						
//					}
//				}
			
			
	}
	
	public Materia updateMateria(Integer id, Materia materia) {
		
		Materia mat = matRepository.findById(id).orElseThrow();
		mat.setNome(materia.getNome());
		mat.setTipo(materia.getTipo());
		mat.setMateriais(materia.getMateriais());
		return matRepository.save(mat);
	}
	
	public void deleteMateriaById(@RequestBody Integer id) {
		matRepository.deleteById(id);
	}
	
	
}
