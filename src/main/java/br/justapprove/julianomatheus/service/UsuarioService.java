package br.justapprove.julianomatheus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.justapprove.julianomatheus.models.Usuario;
import br.justapprove.julianomatheus.repositories.UsuarioRepository;
import org.springframework.data.domain.Sort;
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
	public Usuario readUsuarioByEmail(String email) {
		 return usrrepository.findByEmail(email);
		 
	}
	public List<Usuario> readAllUsuarios() {
		return usrrepository.findAll();
	}
	
	public List<Usuario> readAllUsuariosByPontos() {
		return usrrepository.findAll(Sort.by(Sort.Direction.DESC, "ponto"));
	}
	
	public Usuario updateUsuario(@RequestBody Integer id, Usuario usuario) {
		Usuario usr = usrrepository.findById(id).orElseThrow();
		if(usuario.getEmail() != null && !usuario.getEmail().isBlank()) {
			usr.setEmail(usuario.getEmail());
		}
		
		if(usuario.getSenha() != null && !usuario.getSenha().isBlank()) {
			usr.setSenha(usuario.getSenha());	
		}
		if(usuario.getApelido() != null && !usuario.getApelido().isBlank()) {
			usr.setApelido(usuario.getApelido());	
		}
		
		usr.setImage(usuario.getImage());
		return usrrepository.save(usr);
	}
	
	public Usuario updatePontos(@RequestBody Integer id, Usuario usuario) {
		Usuario usr = usrrepository.findById(id).orElseThrow();
		usr.setPonto(usuario.getPonto());
		return usrrepository.save(usr);
	}
	
	public void deleteUsuarioById(@RequestBody Integer id) {
		usrrepository.deleteById(id);
	}	
	
}