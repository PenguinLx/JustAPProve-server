package br.justapprove.julianomatheus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.justapprove.julianomatheus.models.Questao;
import br.justapprove.julianomatheus.repositories.QuestaoRepository;

@Service
public class QuestaoService {
	@Autowired
	private QuestaoRepository questRepository;
	
	public Questao saveQuestao(@RequestBody Questao questao) {
	
		return questRepository.save(questao);
	}
	
	public Questao readQuestao(@RequestBody Questao questao) {
		return questRepository.getReferenceById(questao.getId());
	}
	
	public Questao updateQuestao(@RequestBody Questao questao, Integer id) {
		Questao quest = questRepository.findById(id).orElseThrow();
		quest.setAlternativas(questao.getAlternativas());
		quest.setDescricao(questao.getDescricao());
		return questRepository.save(quest);
	}
	//deletar por entidade
	public void deleteQuestaoEntity(@RequestBody Questao questao) {
		questRepository.delete(questao);
	}
}
