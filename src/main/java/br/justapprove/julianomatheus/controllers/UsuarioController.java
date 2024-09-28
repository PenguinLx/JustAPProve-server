package br.justapprove.julianomatheus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.justapprove.julianomatheus.models.Usuario;
import br.justapprove.julianomatheus.service.UsuarioService;

@RestController
public class UsuarioController {
	@Autowired
	private UsuarioService usrService;

	@PostMapping("/usuario/save")
	public Usuario save(@RequestBody Usuario usuario) {
		return usrService.saveUsuario(usuario);
	}

}


