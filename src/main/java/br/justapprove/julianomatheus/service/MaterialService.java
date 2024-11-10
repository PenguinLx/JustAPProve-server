package br.justapprove.julianomatheus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.justapprove.julianomatheus.models.Materia;
import br.justapprove.julianomatheus.models.Material;
import br.justapprove.julianomatheus.models.TipoMateria;
import br.justapprove.julianomatheus.repositories.MaterialRepository;

@Service
public class MaterialService {
	
	@Autowired
	private MaterialRepository matlRepository;
	
	public Material saveMaterial(@RequestBody Material material) {
			Materia materia = new Materia();
			//material.setTipo(material.getMateria().getTipo());
		return matlRepository.save(material);
	}
	
	public Optional<Material> readMaterial(@RequestBody Integer id) {
		return matlRepository.findById(id);
	}
	
	public List<Material> readAllMateriais()	{
		return matlRepository.findAll();	
	}
	
	public List<Material> readAllMateriaisByTipoMateria(String tipo){
//			if(mat.get(0).getTipo() == TipoMateria.GEOGRAFIA) {
				Material material = new Material();
//		TipoMateria tipo = matl.get(0).getMateria().getTipo();
//		if(tipo == TipoMateria.GEOGRAFIA) {
//		return matl.get(0).getMateria().getMateriais().get(0).
//		MateriaService matS = new MateriaService();
//		List<Material> listMaterialByTipo;
//matS.readAllMateriasByTipo(matl.get(0).getTipo().toString());
		TipoMateria tipoM;
		//System.out.println(material.getTipo().toString());
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
		return matlRepository.findByTipo(tipoM);
	}
	public Material updateMaterial(@RequestBody Material material, Integer id) {
		Material matl = matlRepository.findById(id).orElseThrow();
		matl.setDescricao(material.getDescricao());
		matl.setVideoEmbedd(material.getVideoEmbedd());
		return matlRepository.save(matl);
	}
	
	public void deleteMaterialById(@RequestBody Integer id) {
		matlRepository.deleteById(id);
	}
	
	
}
