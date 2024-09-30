package br.justapprove.julianomatheus.service;

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
	public Usuario readUsuario(@RequestBody Usuario usuario) {
		return usrrepository.getReferenceById(usuario.getId());
	}
	
	public Usuario updateUsuario(@RequestBody Usuario usuarioDetails, Integer id) {
		Usuario usr = usrrepository.findById(id).orElseThrow(); 
		usr.setNome(usuarioDetails.getNome());
		usr.setSenha(usuarioDetails.getSenha());
		return usrrepository.save(usr);
	}
	
	public void deleteUsuarioEntity(@RequestBody Usuario usuario) {
		usrrepository.delete(usuario);
	}
	
	
	
}
