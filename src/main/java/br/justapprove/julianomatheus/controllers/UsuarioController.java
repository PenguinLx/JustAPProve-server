package br.justapprove.julianomatheus.controllers;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.justapprove.julianomatheus.models.LoginRequest;
import br.justapprove.julianomatheus.models.LoginResponse;
import br.justapprove.julianomatheus.models.Usuario;
import br.justapprove.julianomatheus.service.UsuarioService;
import jakarta.websocket.OnError;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
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
	
	@PutMapping("/updateUsuario/{id}")
	public Usuario updateUsuario(@PathVariable("id") Integer id, @RequestBody Usuario usuario) throws IOException {
		return usrService.updateUsuario(id, usuario);
	}
	
	@PutMapping("/updatePonto/{id}")
	public Usuario updatePontos(@PathVariable("id") Integer id, @RequestBody Usuario usuario) {
		return usrService.updatePontos(id, usuario);
	}
	@DeleteMapping("/delete/{id}")
	public Usuario deleteUsuario(@PathVariable("id") Integer id) {
		 return usrService.deleteUsuarioById(id);
	}

	@PostMapping("/login")
    public ResponseEntity<LoginResponse> userLogin(@RequestBody LoginRequest loginRequest) {
        return usrService.userLogin(loginRequest);
    }
	@PostMapping("/esqueceu")
	 public String forgotPass(@RequestParam("email")String email) {
		return usrService.forgotPass(email);
	}
	
	@PutMapping("/reset")
	 public String resetPass(@RequestParam("token") String token, @RequestParam("senhaN") String senhaN, @RequestParam("senhaN2") String senhaN2) {
		
		return usrService.resetPass(token, senhaN, senhaN2);
		
	}
	}