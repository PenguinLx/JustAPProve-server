package br.justapprove.julianomatheus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.justapprove.julianomatheus.models.Usuario;
import br.justapprove.julianomatheus.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usrrepository;
	
	public Usuario saveUsuario(@RequestBody Usuario usuario) {
		return usrrepository.save(usuario);
	}
	
	public Usuario saveUsuarioEmail(Usuario usuario, @RequestBody String email) {
		 usuario.setEmail(email);
		 return usrrepository.save(usuario);
	}
	public Optional<Usuario> readUsuarioById(Integer id) {
		 return usrrepository.findById(id);
		 
	}
	public List<Usuario> readAllUsuarios() {
		return usrrepository.findAll();
	}
	
	public Usuario updateUsuario(@RequestBody Integer id, Usuario usuarioDetails) {
		Usuario usr = usrrepository.findById(id).orElseThrow(); 
		usr.setEmail(usuarioDetails.getEmail());
		usr.setSenha(usuarioDetails.getSenha());
		usr.setUserName(usuarioDetails.getUserName());
		usr.setImage(usuarioDetails.getImage());
		return usrrepository.save(usr);
	}
	
	public void deleteUsuarioById(@RequestBody Integer id) {
		usrrepository.deleteById(id);
	}	
	public void deleteAllUsuarios() {
		usrrepository.deleteAll();
	}
}