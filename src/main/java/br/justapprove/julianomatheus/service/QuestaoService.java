package br.justapprove.julianomatheus.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import br.justapprove.julianomatheus.models.Alternativa;
import br.justapprove.julianomatheus.models.Questao;
import br.justapprove.julianomatheus.repositories.AlternativaRepository;
import br.justapprove.julianomatheus.repositories.QuestaoRepository;

@Service
public class QuestaoService {
	@Autowired
	private QuestaoRepository questRepository; 

	public Questao saveQuestao(MultipartFile descricao, List<Alternativa> alternativas) throws IOException {
		Questao questao = new Questao();
		questao.setDescricao(descricao.getBytes());
		questao.setAlternativas(alternativas);
		return questRepository.save(questao);
	}

	public Optional<Questao> readQuestao(@RequestBody Integer id) {
		return questRepository.findById(id);
	}

	public List<Questao> readAllQuestoes() {
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

	public Questao insertImage(Integer idQuestao, MultipartFile image) throws IOException {
		// final String PATH = "./src/main/resources/static/upload_questao/";
		
		Questao questao = questRepository.findById(idQuestao).orElseThrow();
		//byte[] imagem;
			
			questao.setDescricao(image.getBytes());

			return questRepository.save(questao);
		
	}
	
//	public String saveImage(MultipartFile image) {
//		AlternativaRepository altRepo;
//		Questao questao = questRepository.save(Questao.builder().alternativas(altRepo.findAll()).descricao(image.getBytes()).build());
//		return;
//	}

	public void deleteAllQuestoes() {
		questRepository.deleteAll();
	}
}
