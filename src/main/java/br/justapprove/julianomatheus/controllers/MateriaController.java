package br.justapprove.julianomatheus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.justapprove.julianomatheus.models.Materia;
import br.justapprove.julianomatheus.service.MateriaService;

@RestController
@RequestMapping("/api/materia")
public class MateriaController {

	
	@Autowired
	private MateriaService matService;
	
	@PostMapping("/materia/save")
	public Materia saveMateria(Materia materia) {
		return matService.saveMateria(materia);
	}
	
	@GetMapping("/materia/read")
	public Materia readMateria(Materia materia) {
		return matService.readMateria(materia);
	}
	
	@PostMapping("/materia/update")
	public Materia updateMateria(Materia materia) {
		return matService.updateMateria(materia, materia.getId());
	}
	
	@DeleteMapping("/materia/delete")
	public void deleteMateria(Materia materia) {
		matService.deleteMateriaEntity(materia);
	}
	
	
}
