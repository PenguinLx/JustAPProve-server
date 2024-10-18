package br.justapprove.julianomatheus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/read/{id}")
	public Materia readMateria(Integer id) {
		return matService.readMateria(id).orElseThrow();
	}
	
	@GetMapping("/readAll")
	public List<Materia> readAllMaterias(){
		return matService.readAllMaterias();
	}
	
	@PutMapping("/update")
	public Materia updateMateria(Materia materia) {
		return matService.updateMateria(materia, materia.getId());
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteMateria(@PathVariable("id") Integer id) {
		matService.deleteMateriaById(id);
	}	
	
}