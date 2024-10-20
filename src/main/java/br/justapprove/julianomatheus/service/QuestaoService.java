package br.justapprove.julianomatheus.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.justapprove.julianomatheus.datatransfer.AlternativaDT;
import br.justapprove.julianomatheus.models.Alternativa;
import br.justapprove.julianomatheus.models.Questao;
import br.justapprove.julianomatheus.repositories.QuestaoRepository;

@Service
public class QuestaoService {
	@Autowired
	private QuestaoRepository questRepository; 

	public Questao saveQuestao(MultipartFile descricao, String stringJson) throws IOException {
        Questao questao = new Questao();

        questao.setDescricao(descricao.getBytes());
        List<AlternativaDT> alternativasDT = new ObjectMapper().readValue(stringJson, new TypeReference<List<AlternativaDT>>() {});
        
        List<Alternativa> alternativas = new ArrayList<>();
        
        // O que enviar pelo PostMan?
        // Body -> form-data
        // descricao File arquivo.fds
        // alternativas Text [{"correta": 1, "descricao": "Alternativa correta"}, {"correta": 0, "descricao": "Alternativa errada"}, {"correta": 0, "descricao": "Alternativa errada"}]
        for (AlternativaDT alternativaDT : alternativasDT) {
            Alternativa alternativa = new Alternativa();
            alternativa.setDescricao(alternativaDT.getDescricao());
            alternativa.setCorreta(alternativaDT.isCorreta());
            alternativa.setQuestao(questao);
            alternativas.add(alternativa);
        }
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

	public Questao insertImage(Integer idQuestao, MultipartFile descricao) throws IOException {
		// final String PATH = "./src/main/resources/static/upload_questao/";
		
		Questao questao = questRepository.findById(idQuestao).orElseThrow();
		//byte[] imagem;
			
			questao.setDescricao(descricao.getBytes());

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
