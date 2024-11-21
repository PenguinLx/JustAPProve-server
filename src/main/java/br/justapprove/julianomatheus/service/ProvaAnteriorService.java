package br.justapprove.julianomatheus.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.justapprove.julianomatheus.models.ProvaAnterior;
import br.justapprove.julianomatheus.repositories.ProvaAnteriorRepository;

@Service
public class ProvaAnteriorService {

	@Autowired
	private ProvaAnteriorRepository provaRepository;

	public ProvaAnterior saveProva(MultipartFile pdf, String titulo) throws IOException {
		ProvaAnterior provaAnterior = new ProvaAnterior();
		provaAnterior.setTitulo(titulo);
		provaAnterior.setPdf(pdf.getBytes());
		return provaRepository.save(provaAnterior);
	}
//	public void insertPdf(Integer id, MultipartFile pdf) {
//		ProvaAnterior prova = provaRepository.findById(id).orElseThrow();
//		byte[] pdfB;
//	    
//		try {
//			pdfB = pdf.getBytes();
//			prova.setPdf(pdfB);
//			provaRepository.save(prova);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	public Optional<ProvaAnterior> readProva(@RequestBody Integer id) {
		return provaRepository.findById(id);
	}
	
	public List<ProvaAnterior> readAllProvas(){
		return provaRepository.findAll(Sort.by(Sort.Direction.DESC, "titulo"));
	}

	public ProvaAnterior updateProva(MultipartFile pdf, String titulo, Integer id) throws IOException {
		
	ProvaAnterior prova = provaRepository.findById(id).orElseThrow();
	prova.setTitulo(titulo);
	prova.setPdf(pdf.getBytes());
	return provaRepository.save(prova);
}
	public void deleteProvaAnteriorById(@RequestBody Integer id) {
		provaRepository.deleteById(id);
	}
	
	

}
