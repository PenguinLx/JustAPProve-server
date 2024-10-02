package br.justapprove.julianomatheus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.justapprove.julianomatheus.models.Usuario;
import br.justapprove.julianomatheus.service.UsuarioService;
import jakarta.websocket.OnError;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	//TODO:colocar mapping para /error
	//TODO:fazer metodos para email, ponto e username(aqui e no Service);
	@Autowired
	private UsuarioService usrService;

	@PostMapping("/save")
	public Usuario save(@RequestBody Usuario usuario) {
		return usrService.saveUsuario(usuario);
	}
	
	@GetMapping("/read")
	public Usuario read(@RequestBody Usuario usuario) {
		return usrService.readUsuario(usuario);
	}
	
	@PostMapping("/update")
	public Usuario updateUsuario(@RequestBody Usuario usuario) {
		return usrService.updateUsuario(usuario, usuario.getId());
	}

	@DeleteMapping("/delete")
	public void deleteUsuario(Usuario usuario) {
		 usrService.deleteUsuarioEntity(usuario);
	}
	@OnError
	public void onError() {
	
	}
}