package br.justapprove.julianomatheus.service;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.net.http.HttpHeaders;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import br.justapprove.julianomatheus.models.ProvaAnterior;
import br.justapprove.julianomatheus.repositories.ProvaAnteriorRepository;

@Service
public class ProvaAnteriorService {

	@Autowired
	private ProvaAnteriorRepository provaRepository;

	public ProvaAnterior saveProva(@RequestBody ProvaAnterior provaAnterior) {
		return provaRepository.save(provaAnterior);
	}
	public void insertPdf(Integer id, MultipartFile pdf) {
		ProvaAnterior prova = provaRepository.findById(id).orElseThrow();
		byte[] pdfB;
	    
		try {
			pdfB = pdf.getBytes();
			prova.setPdf(pdfB);
			provaRepository.save(prova);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Optional<ProvaAnterior> readProva(@RequestBody Integer id) {
		return provaRepository.findById(id);
	}
	
	public List<ProvaAnterior> readAllProvas(){
		return provaRepository.findAll();
	}

	public ProvaAnterior updateProva(@RequestBody ProvaAnterior provaAnterior, Integer id) {
		
	ProvaAnterior prova = provaRepository.findById(id).orElseThrow();
	prova.setTitulo(provaAnterior.getTitulo());
	prova.setPdf(provaAnterior.getPdf());
	return provaRepository.save(prova);
}
	public void deleteProvaAnteriorById(@RequestBody Integer id) {
		provaRepository.deleteById(id);
	}
	
	public void deleteAllProvaAnterior() {
		provaRepository.deleteAll();
	}

}
