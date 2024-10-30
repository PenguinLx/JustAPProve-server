package br.justapprove.julianomatheus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.justapprove.julianomatheus.models.LoginRequest;
import br.justapprove.julianomatheus.models.LoginResponse;
import br.justapprove.julianomatheus.models.Usuario;
import br.justapprove.julianomatheus.repositories.UsuarioRepository;
@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usrrepository;
	
//	public Usuario saveUsuario(@RequestBody Usuario usuario) {
//		while (!verifyApelido(usuario)) {
//			Random random = new Random();
//			int randomNumber = random.nextInt(8999) + 1000;
//            usuario.setApelido("Estudante" + randomNumber);
//		}
//		return usrrepository.save(usuario);
//	}
	
	public Usuario saveUsuario(@RequestBody Usuario usuario) {
		Usuario usrResposta = new Usuario();
		while (!verifyApelido(usuario)) {
			usuario.setApelido("Estudante" + randomizeNumber());
		}
		if (!verifyEmail(usuario)) {
			usrResposta.setEmail("Email já está sendo utilizado");
			return usrResposta;
		} if (!checkRealEmail(usuario.getEmail())) {
			usrResposta.setEmail("Email não conhecível");
			return usrResposta;
		} else {
			return usrrepository.save(usuario);
		}
		
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
		return usrrepository.findAll(Sort.by(Sort.Direction.DESC, "pontos"));
	}
	
	public ResponseEntity<LoginResponse> userLogin(LoginRequest loginRequest) {
		LoginResponse response = new LoginResponse();
		
		if (readUsuarioByEmail(loginRequest.getEmail()).getEmail().equals(loginRequest.getEmail()) && 
        		readUsuarioByEmail(loginRequest.getEmail()).getSenha().equals(loginRequest.getSenha())) {
            response.setResposta(true);
            response.setId(readUsuarioByEmail(loginRequest.getEmail()).getId());
            response.setApelido(readUsuarioByEmail(loginRequest.getEmail()).getApelido());
            response.setPontos(readUsuarioByEmail(loginRequest.getEmail()).getPontos());
        } else {
        	response.setResposta(false);
        }
		
		return ResponseEntity.ok(response);
	}
	
	public List<String> readAllUsuariosApelidos() {
		List<Usuario> listaUsuarios = usrrepository.findAll();
		List<String> apelidos = new ArrayList<String>();
		
		for (Usuario usuario : listaUsuarios) {
			apelidos.add(usuario.getApelido());
		}
		return apelidos;
	}
	
	public boolean verifyApelido(Usuario usuario) {
		List<String> apelidos = readAllUsuariosApelidos();
		
		if (apelidos.size() == 0) {
            usuario.setApelido("Estudante" + randomizeNumber());
            return true;
		}
		
		for (int x = 0; x<apelidos.size(); x++) {
			if (usuario.getApelido() == null || usuario.getApelido().equals(apelidos.get(x))) {
					return false;
			}
		}
		return true;
	}
	
	public List<String> readAllUsuariosEmails() {
		List<Usuario> listaUsuarios = usrrepository.findAll();
		List<String> emails = new ArrayList<String>();
		
		for (Usuario usuario : listaUsuarios) {
			emails.add(usuario.getEmail());
		}
		return emails;
	}
	
	public boolean verifyEmail(Usuario usuario) {
		List<String> emails = readAllUsuariosEmails();
		
		for (int x = 0; x<emails.size(); x++) {
			if (usuario.getEmail().equals(emails.get(x))) {
					return false;
			}
		}
	    return true;
	}
	
	public boolean checkRealEmail(String email) {
		String padrao = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(padrao);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
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
			if (!verifyApelido(usuario) || usuario.getApelido().equals("Apelido já em uso")) {
				usr.setApelido("Apelido já em uso");
				return usr;
			} else {
				usr.setApelido(usuario.getApelido());	
			}
				
		}
		
		usr.setImage(usuario.getImage());
		return usrrepository.save(usr);
	}
	
	public Usuario updatePontos(@RequestBody Integer id, Usuario usuario) {
		Usuario usr = usrrepository.findById(id).orElseThrow();
		usr.setPontos(usr.getPontos() + usuario.getPontos());
		return usrrepository.save(usr);
	}
	
	public void deleteUsuarioById(@RequestBody Integer id) {
		usrrepository.deleteById(id);
	}	
	
	public int randomizeNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(8999) + 1000;
		return randomNumber;
	}
	
}