package br.justapprove.julianomatheus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.justapprove.julianomatheus.dao.UsuarioDAO;
import br.justapprove.julianomatheus.models.Usuario;

@RestController
public class UsuarioController {
	@Autowired
	private UsuarioDAO usrDAO;
	
	@PostMapping("/usuario/save")
	public Usuario save(@RequestBody Usuario usuario) {
		return usrDAO.save(usuario);
	}
	

}
