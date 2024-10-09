package br.justapprove.julianomatheus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.justapprove.julianomatheus.models.LoginRequest;
import br.justapprove.julianomatheus.models.LoginResponse;
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
	@PostMapping("/saveUser")
	public Usuario save(@RequestBody Usuario usuario) {
		 return usrService.saveUsuario(usuario);
	}
	@GetMapping("/readUserById/{id}")
	@ResponseBody
	public Usuario read(@PathVariable("id") Integer id) { 
		return usrService.readUsuarioById(id).orElseThrow();
	}
	@GetMapping("/readAll")
	public List<Usuario> readAllUsuarios() {
		return usrService.readAllUsuarios();
	}
	
	@GetMapping("/readAllUsuariosByPontos")
	public List<Usuario> readAllUsuariosByPontos() {
		return usrService.readAllUsuariosByPontos();
	}
	
	@PutMapping("/update/{id}")
	public Usuario updateUsuario(@PathVariable("id") Integer id, @RequestBody Usuario usuario) {
		return usrService.updateUsuario(id, usuario);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteUsuario(@PathVariable("id") Integer id) {
		 usrService.deleteUsuarioById(id);
	}
	//DANGER:DELETA TUDO, USAR COM PRECAUÇÃO!//
	@DeleteMapping("/deleteAll")
	public void deleteAll() {
		usrService.deleteAllUsuarios();
	}
	@PostMapping("/login")
    public ResponseEntity<LoginResponse> userLogin(@RequestBody LoginRequest loginRequest) {
        LoginResponse response = new LoginResponse();

        if (usrService.readUsuarioByEmail(loginRequest.getEmail()).getEmail().equals(loginRequest.getEmail()) && 
        		usrService.readUsuarioByEmail(loginRequest.getEmail()).getSenha().equals(loginRequest.getSenha())) {
            response.setResposta(true);
        } else {
        	response.setResposta(false);
        }

        return ResponseEntity.ok(response);
    }
	@OnError()
	public void onError() {
	}
}