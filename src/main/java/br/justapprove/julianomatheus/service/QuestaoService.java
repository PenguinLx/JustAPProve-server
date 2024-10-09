package br.justapprove.julianomatheus.service;

import java.util.List;
import java.util.Optional;

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
	
	public Optional<Questao> readQuestao(@RequestBody Integer id) {
		return questRepository.findById(id);
	}
	
	public List<Questao> readAllQuestoes(){
		return questRepository.findAll();
	}
	
	public Questao updateQuestao(@RequestBody Questao questao, Integer id) {
		Questao quest = questRepository.findById(id).orElseThrow();
		quest.setAlternativas(questao.getAlternativas());
		quest.setDescricao(questao.getDescricao());
		return questRepository.save(quest);
	}
		public void deleteQuestaoById(@RequestBody Integer id) {
		questRepository.deleteById(id);
	}
		
	public void deleteAllQuestoes() {
		questRepository.deleteAll();
	}
}
