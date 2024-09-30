package br.justapprove.julianomatheus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.justapprove.julianomatheus.models.Material;
import br.justapprove.julianomatheus.service.MaterialService;

@RestController
@RequestMapping("/api/material")
public class MaterialController {

	@Autowired
	private MaterialService matlService;
	
	
	@PostMapping("/material/save")
	public Material saveMaterial(Material material) {
		return matlService.saveMaterial(material);
	}
	
	@GetMapping("/material/read")
	public Material readMaterial(Material material) {
		return matlService.readMaterial(material);
	}
	
	@PostMapping("/material/update")
	public Material updateMaterial(Material material) {
		return matlService.updateMaterial(material, material.getId());
	}
	
	@DeleteMapping("/material/delete")
	public void deleteMaterial(Material material) {
		matlService.deleteMaterialEntity(material);
	}
}
