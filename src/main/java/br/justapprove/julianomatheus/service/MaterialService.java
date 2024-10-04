package br.justapprove.julianomatheus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.justapprove.julianomatheus.models.Material;
import br.justapprove.julianomatheus.repositories.MaterialRepository;

@Service
public class MaterialService {
	
	@Autowired
	private MaterialRepository matlRepository;
	
	public Material saveMaterial(@RequestBody Material material) {
		return matlRepository.save(material);
	}
	
	public Optional<Material> readMaterial(@RequestBody Integer id) {
		return matlRepository.findById(id);
	}
	
	public List<Material> readAllMateriais()	{
		return matlRepository.findAll();	
	}
	
	public Material updateMaterial(@RequestBody Integer id, Material material) {
		Material matl = matlRepository.findById(id).orElseThrow();
		matl.setArtigo(material.getArtigo());
		matl.setVideo(material.getVideo());
		return matlRepository.save(matl);
	}
	
	public void deleteMaterialById(@RequestBody Integer id) {
		matlRepository.deleteById(id);
	}
	
	public void deleteAllMaterial() {
		matlRepository.deleteAll();
	}
}
