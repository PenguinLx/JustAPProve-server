package br.justapprove.julianomatheus.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.justapprove.julianomatheus.models.Alternativa;
import br.justapprove.julianomatheus.models.Questao;
import br.justapprove.julianomatheus.service.QuestaoService;

@RestController
@RequestMapping("/questoes")
public class QuestaoController {

	@Autowired
	private QuestaoService questService;

	
	@PostMapping("/save")
	public Questao saveQuestao(@RequestParam("descricao") MultipartFile descricao, @RequestParam("alternativas") List<Alternativa> alternativas) throws IOException {
		return questService.saveQuestao(descricao, alternativas);
	}
	
	@GetMapping("/read/{id}")
	public Questao readQuestao(Integer id) {
		return questService.readQuestao(id).orElseThrow();
	}
	
	@GetMapping("/readAll")
	public List<Questao> readAllQuestoes(){
		return questService.readAllQuestoes();
	}
	
	@PutMapping("/update")
	public Questao updateQuestao(Questao questao) {
		return questService.updateQuestao(questao, questao.getId());
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteQuestao(@PathVariable("id") Integer id) {
		questService.deleteQuestaoById(id);
	}
	
	@DeleteMapping("/deleteAll")
	public void deleteAllQuestao() {
		questService.deleteAllQuestoes();
	}
	
	@PutMapping("/saveImage/{id}")
	public void saveImage(@PathVariable("id") Integer idQuestao,@RequestParam("image") MultipartFile image) throws IOException {
		questService.insertImage (idQuestao, image);
	}
	
}