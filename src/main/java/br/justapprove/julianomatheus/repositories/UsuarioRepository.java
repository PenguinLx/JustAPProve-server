package br.justapprove.julianomatheus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.justapprove.julianomatheus.models.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	Usuario findByEmail(String email);
	Usuario findByToken(String token);
}
