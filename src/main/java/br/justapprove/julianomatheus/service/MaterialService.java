package br.justapprove.julianomatheus.service;

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
	
	public Material readMaterial(@RequestBody Material material) {
		return matlRepository.getReferenceById(material.getId());
	}
	
	public Material updateMaterial(@RequestBody Material material, Integer id) {
		Material matl = matlRepository.findById(id).orElseThrow();
		matl.setArtigo(material.getArtigo());
		matl.setVideo(material.getVideo());
		return matlRepository.save(matl);
	}
	
	public void deleteMaterialEntity(@RequestBody Material material) {
		matlRepository.delete(material);
	}
}
