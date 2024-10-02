package br.justapprove.julianomatheus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.justapprove.julianomatheus.models.Questao;
import br.justapprove.julianomatheus.service.QuestaoService;

@RestController
@RequestMapping("/questoes")
public class QuestaoController {

	@Autowired
	private QuestaoService questService;

	
	@PostMapping("/save")
	public Questao saveQuestao(Questao questao) {
		return questService.saveQuestao(questao);
	}
	
	@GetMapping("/read")
	public Questao readQuestao(Questao questao) {
		return questService.readQuestao(questao);
	}
	
	@PostMapping("/update")
	public Questao updateQuestao(Questao questao) {
		return questService.updateQuestao(questao, questao.getId());
	}
	
	@DeleteMapping("/delete")
	public void deleteQuestao(Questao questao) {
		questService.deleteQuestaoEntity(questao);
	}
	
}