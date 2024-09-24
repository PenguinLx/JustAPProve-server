package br.justapprove.julianomatheus.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.justapprove.julianomatheus.models.Usuario;
import br.justapprove.julianomatheus.repositories.UsuarioRepository;

@Service
public class UsuarioDAO {
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario save(Usuario usuario) {
		return repository.save(usuario);
		
	}
	

}
