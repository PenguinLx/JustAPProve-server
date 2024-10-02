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
@RequestMapping("/materia")
public class MateriaController {

	
	@Autowired
	private MateriaService matService;
	
	@PostMapping("/save")
	public Materia saveMateria(Materia materia) {
		return matService.saveMateria(materia);
	}
	
	@GetMapping("/read")
	public Materia readMateria(Materia materia) {
		return matService.readMateria(materia);
	}
	
	@PostMapping("/update")
	public Materia updateMateria(Materia materia) {
		return matService.updateMateria(materia, materia.getId());
	}
	
	@DeleteMapping("/delete")
	public void deleteMateria(Materia materia) {
		matService.deleteMateriaEntity(materia);
	}	
}