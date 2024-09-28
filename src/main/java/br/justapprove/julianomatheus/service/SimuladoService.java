package br.justapprove.julianomatheus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.justapprove.julianomatheus.repositories.SimuladoRepository;

@Service
public class SimuladoService {

	@Autowired
	private SimuladoRepository simRepository;
	
}
