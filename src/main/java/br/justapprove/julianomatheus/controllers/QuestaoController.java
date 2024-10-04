package br.justapprove.julianomatheus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.justapprove.julianomatheus.models.Questao;
import br.justapprove.julianomatheus.service.QuestaoService;

@RestController
@RequestMapping("/questao")
public class QuestaoController {

	@Autowired
	private QuestaoService questService;

	
	@PostMapping("/save")
	public Questao saveQuestao(Questao questao) {
		return questService.saveQuestao(questao);
	}
	
	@GetMapping("/read/{id}")
	public Questao readQuestao(Integer id) {
		return questService.readQuestao(id).orElseThrow();
	}
	
	@GetMapping("/readAll")
	public List<Questao> readAllQuestoes(){
		return questService.readAllQuestoes();
	}
	
	@PutMapping("/update{id}")
	public Questao updateQuestao(@PathVariable Integer id, @RequestBody Questao questao) {
		return questService.updateQuestao(id, questao);
	}
	
	@DeleteMapping("/delete{id}")
	public void deleteQuestao(@PathVariable("id") Integer id) {
		questService.deleteQuestaoById(id);
	}
	
	@DeleteMapping("/deleteAll")
	public void deleteAllQuestao() {
		questService.deleteAllQuestoes();
	}
	
}