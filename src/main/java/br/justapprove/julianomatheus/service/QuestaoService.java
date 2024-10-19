package br.justapprove.julianomatheus.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.justapprove.julianomatheus.models.Alternativa;
import br.justapprove.julianomatheus.models.Questao;
import br.justapprove.julianomatheus.repositories.QuestaoRepository;

@Service
public class QuestaoService {
	@Autowired
	private QuestaoRepository questRepository; 

	public Questao saveQuestao(Questao questao) throws JsonProcessingException {
		//Questao questao = new Questao();

		if (questao.getAlternativas() != null) {
			//VERIFICA SE AS ALTERNATIVAS SÃO NULAS
            for (Alternativa alternativa : questao.getAlternativas()) {
            	//ITERA SOBRE CADA ALTERNATIVA DA LISTA PARA REALIZAR OPERAÇÕES
                alternativa.setQuestao(questao); 
                //atribui a instância da Questao atual a cada uma das instâncias de Alternativa(da lista na classe questao)
                // A Questao já possui uma lista de Alternativas associadas, mas a Alternativa também precisa saber a qual Questao ela pertence(Isso é necessário para que o JPA possa mapear corretamente a chave estrangeira (id_questao) na tabela de Alternativa no banco de dados. Sem essa atribuição, o campo id_questao na tabela Alternativa poderia ficar nulo, o que causaria problemas de integridade referencial no banco de dados)
            }
        }
		
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
