package br.justapprove.julianomatheus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.justapprove.julianomatheus.models.Usuario;
import br.justapprove.julianomatheus.repositories.UsuarioRepository;

//@RestController
@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usrrepository;
	
	//@PostMapping("/usuario/save")
	public Usuario saveUsuario(@RequestBody Usuario usuario) {
		//return usrDAO.Save(usuario);
		return usrrepository.save(usuario);
	}
	//@PostMapping("/usuario/read")
	public Usuario readUsuario(@RequestBody Usuario usuario) {
		return usrrepository.getReferenceById(usuario.getId());
	}
	
	//@PostMapping("/usuario/update")
	public Usuario updateUsuario(@RequestBody Usuario usuarioDetails, Integer id) {
		Usuario usr = usrrepository.findById(id).orElseThrow(); 
		usr.setNome(usuarioDetails.getNome());
		usr.setSenha(usuarioDetails.getSenha());
		return usrrepository.save(usr);
	}
}
