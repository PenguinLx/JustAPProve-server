package br.justapprove.julianomatheus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.justapprove.julianomatheus.models.Material;
import br.justapprove.julianomatheus.service.MaterialService;

@RestController
@RequestMapping("/material")
public class MaterialController {

	@Autowired
	private MaterialService matlService;
	
	
	@PostMapping("/save")
	public Material saveMaterial(Material material) {
		return matlService.saveMaterial(material);
	}
	
	@GetMapping("/read/{id}")
	public Material readMaterial(Integer id) {
		return matlService.readMaterial(id).orElseThrow();
	}
	@GetMapping("/readAll")
	public List<Material> readAllMateriais(){
		return matlService.readAllMateriais();
	}
//	@GetMapping("/readAllMateriasByTipoMateria")
//	public List<Material> readAllMateriaisByTipoMateria(@RequestParam("tipo") String tipo){
//		return matlService.readAllMateriaisByTipoMateria(tipo);
//	}

	
	@PutMapping("/update")
	public Material updateMaterial(Material material) {
		return matlService.updateMaterial(material, material.getId());
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteMaterial(@PathVariable("id") Integer id) {
		matlService.deleteMaterialById(id);
	}
	
	
}